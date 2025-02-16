# Ejercicio de Sistema de Pagos

## Descripción
Este proyecto es un sistema de pagos que se compone de cuatro módulos principales. Cada módulo desempeña un papel específico dentro del sistema, facilitando la gestión y procesamiento de los pagos.

## Módulos

### 1. payments-api
Este módulo es la API donde se realizan las consultas, altas y modificaciones de los pagos. Proporciona endpoints para interactuar con el sistema de pagos, permitiendo a los usuarios realizar diversas operaciones relacionadas con los pagos.

### 2. payments-core
El módulo `payments-core` utiliza Kafka y se ejecuta en segundo plano, esperando modificaciones de pago y realizando estas actualizaciones en paralelo. Este módulo garantiza que los pagos se procesen de manera eficiente y en tiempo real.

### 3. payments-data
`payments-data` es una librería de base de datos donde se encuentran los repositorios y los modelos. Este módulo maneja la persistencia de datos y proporciona acceso a la información almacenada en la base de datos.

### 4. payments-services
En este módulo se encuentran las interfaces de los servicios. Define las operaciones que pueden realizarse en el sistema de pagos y actúa como un puente entre la API y el core del sistema.

## Documentación
La documentación del proyecto se encuentra en la carpeta `site` en formato Javadoc. Esta documentación proporciona detalles sobre la implementación y uso de cada uno de los módulos, así como descripciones detalladas de las clases y métodos.


Para consultar la documentación del proyecto:
[https://josuesilva89v.github.io/payments-sample-spring-kafka/](https://josuesilva89v.github.io/payments-sample-spring-kafka/)

---
