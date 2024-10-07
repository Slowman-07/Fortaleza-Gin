![Diagrama](//www.plantuml.com/plantuml/png/RPBFIiD04CRl-nHBxpre_nGyI4iG4HIaeFSX6UDWiXjcfq5z9my-Gr_CJBec8Uobx7ppcs-dtsOV15XETMKgV1ChtZALxs8BOio5l3EGYsURLOHEC5RFx5l4mdEi5_V8shQ7eYP7GHY4Mh-m42xId2lGldQ7hlrb7trv_Wb2EIYlUf6mrf4du0yKSgM2OsNCAM0E0HKEkZHmjE_1b-mgHMI-RdX0hbF8WslLXib7QfKqWhg1yo-4-OuwiHudZbZsqGnfHcGpDNMem14RpzES8heTqOE3YhvroRhHg9IDcmpupfXubLqk-np-qqtN6pEyh0gQIlzyYM9bXdzw4TPpOJV5jwOZkkEjDkoDlViKqglDlllLp-yF)

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
