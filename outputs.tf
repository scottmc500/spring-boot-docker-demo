output "resource_group_name" {
  value     = azurerm_resource_group.scott-resource-group.name
  sensitive = false
}

output "resource_group_location" {
  value     = azurerm_resource_group.scott-resource-group.location
  sensitive = false
}

output "client_certificate" {
  value     = azurerm_kubernetes_cluster.scott-k8s-cluster.kube_config[0].client_certificate
  sensitive = true
}

output "kube_config" {
  value     = azurerm_kubernetes_cluster.scott-k8s-cluster.kube_config_raw
  sensitive = true
}

output "kubelet_identity" {
  value     = azurerm_kubernetes_cluster.scott-k8s-cluster.kubelet_identity
  sensitive = false
}

output "assignment_stuff" {
  value     = azurerm_role_assignment.assign_registry_to_cluster
  sensitive = false
}