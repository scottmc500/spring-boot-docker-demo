variable "resource_group_name" {
  description = "The name of the resource group in which to create the resources."
  type        = string
  default     = "MyResourceGroup"
}

variable "resource_group_location" {
  description = "The Azure region where the resource group will be created."
  type        = string
  default     = "East US"
}

variable "container_image_name" {
  description = "The name of the container image to be used in the container group."
  type        = string
  default     = "springdemo"
}

variable "container_registry_name" {
  description = "The name of the Azure Container Registry."
  type        = string
  default     = "scott1264registry"
}

variable "container_registry_sku" {
  description = "The SKU of the Azure Container Registry."
  type        = string
  default     = "Standard"
}