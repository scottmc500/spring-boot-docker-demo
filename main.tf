terraform {
  backend "remote" {
    hostname = "app.terraform.io"
    organization = "scottmc500"
    workspaces {
      name = "springbootdemo-dev"
    }
  }
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = ">= 3.0.0"
    }
  }
}

provider "azurerm" {
  subscription_id = "1a0a6d17-04fa-4014-b67e-a70b121d990c"
  features {}
}

resource "azurerm_resource_group" "scott-resource-group" {
  name     = var.resource_group_name
  location = var.resource_group_location
}

resource "azurerm_container_registry" "scott-container-registry" {
  name                = var.container_registry_name
  resource_group_name = azurerm_resource_group.scott-resource-group.name
  location            = azurerm_resource_group.scott-resource-group.location
  sku                 = var.container_registry_sku
  admin_enabled       = true
}

resource "azurerm_kubernetes_cluster" "scott-k8s-cluster" {
  name                = "scott-k8s-cluster"
  resource_group_name = azurerm_resource_group.scott-resource-group.name
  location            = azurerm_resource_group.scott-resource-group.location
  dns_prefix          = "scott-springbootdemo"
  network_profile {
    network_plugin    = "kubenet"
    load_balancer_sku = "standard"
  }
  default_node_pool {
    name                        = "default"
    node_count                  = 1
    vm_size                     = "Standard_D2pds_v5"
    temporary_name_for_rotation = "blah123"
  }
  identity {
    type = "SystemAssigned"
  }
  tags = {
    Environment = "Development"
  }
}

resource "azurerm_role_assignment" "assign_registry_to_cluster" {
  principal_id                     = azurerm_kubernetes_cluster.scott-k8s-cluster.kubelet_identity[0].object_id
  role_definition_name             = "AcrPull"
  scope                            = azurerm_container_registry.scott-container-registry.id
  skip_service_principal_aad_check = true
}