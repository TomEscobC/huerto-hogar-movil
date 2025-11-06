# Huerto Hogar - Aplicación Móvil para Gestión de Huertos

Esta es la aplicación móvil de Huerto Hogar construida con Kotlin y Jetpack Compose para cumplir con la rúbrica DSY1105.

## Propósito
Ayuda a los usuarios a gestionar y monitorear sus huertos domésticos, registrando siembras, cosechas y actividades de mantenimiento con documentación fotográfica y ubicación geográfica.

## Tecnologías Utilizadas
- Kotlin
- Jetpack Compose
- ViewModel y StateFlow
- Room Database
- Navigation Component
- Camera API
- Location Services

## Características
- Interfaz jerárquica y usable (IL2.1)
- Formularios con validación visual por campo
- Lógica de validación desacoplada
- Animaciones funcionales
- Persistencia local
- Acceso a 2 recursos nativos (cámara y ubicación)
- Arquitectura MVVM con estructura modular

## Estructura del Proyecto
```
app/src/main/java/com/huertohogar/
├── core/
│   ├── database/
│   ├── navigation/
│   ├── permissions/
│   └── utils/
├── ui/
│   ├── components/
│   ├── theme/
│   └── screens/
├── data/
├── domain/
└── MainActivity.kt
```

## Instalación
1. Asegúrate de tener Android Studio con Kotlin configurado
2. Abre el proyecto en Android Studio
3. Sincroniza el proyecto con Gradle
4. Ejecuta en un dispositivo Android o emulador