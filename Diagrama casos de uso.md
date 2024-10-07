@startuml
left to right direction
actor Cliente
actor Proveedor
actor "Gerente Administrativo" as Admin
actor "Gerente de Ventas y Logística" as Vendedor
actor "Gerente de Marketing" as Marketing

usecase "Gestionar Ventas" as UC1
usecase "Gestionar Compras" as UC2
usecase "Gestionar Inventario" as UC3
usecase "Gestionar Campañas de Marketing" as UC4
usecase "Registrar Cliente" as UC5
usecase "Generar Reporte de Ventas" as UC6
usecase "Analizar Impacto de Campañas" as UC7

Cliente -- UC1
Vendedor -- UC1
Vendedor -- UC5
Proveedor -- UC2
Admin -- UC2
Admin -- UC3
Marketing -- UC4
Marketing -- UC7
Admin -- UC6
UC4 --> UC7 : Extiende
@enduml
