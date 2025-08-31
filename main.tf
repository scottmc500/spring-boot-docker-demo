terraform {
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
  admin_enabled       = false
}