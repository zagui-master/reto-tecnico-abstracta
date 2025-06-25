# Framework de Automatización Zagui

## Reto Técnico - Abstracta

## 🧪 Descripción General

Framework de automatización de pruebas funcionales para aplicaciones web utilizando **Selenium WebDriver**, **JUnit 5**,
**Cucumber** y el patrón **Page Object Model (POM)**. Diseñado para escalabilidad, mantenibilidad y claridad del código.

## 🚀 Tecnologías Clave

- **Selenium WebDriver:** Interacción automatizada con navegadores
- **JUnit 5:** Framework para la ejecución estructurada de pruebas
- **Cucumber:** Integración BDD para describir escenarios legibles por humanos
- **Page Object Model (POM):** Organización modular de acciones y elementos de la UI
- **Gradle:** Gestión eficiente del build y las dependencias
- **GitHub Actions:** Integración continua automática al realizar cambios

## 🎯 Características

- ✔️ Estructura modular y reutilizable
- ✔️ Integración con GitHub Actions para ejecución automática
- ✔️ Utilidades personalizadas para interacciones comunes
- ✔️ Reportes automatizados con `cucumber-reporting`
- ✔️ Enfoque en buenas prácticas y mantenibilidad

## 📁 Estructura del Proyecto

```
      src/
      ├── main/
      │   └── java/
      │       └── zagui/
      │           ├── apiZagui/
      │           │   └── Page.java
      │           └── driverManager/
      │               └── Driver.java
      └── test/
      └── java/
      ├── browserManager/
      │   └── BrowserManager.java
      ├── generateReport/
      │   ├── GenerateReport.java
      │   └── ScreenshotReport.java
      ├── pages/
      │   ├── CartPage.java
      │   ├── HeaderPage.java
      │   ├── SearchPage.java
      │   └── YourStorePage.java
      ├── runners/
      │   └── TestRunner.java
      ├── steps/
      │   └── CartSteps.java
      └── resources/
          └── features/
            └── opencart_cart.feature

```

## ▶️ Ejecutar Pruebas

### 1. Desde tu IDE

Para ejecutar pruebas desde tu IDE, ejecuta la suite de pruebas `TestRunner.java` como una suite de pruebas JUnit.

### 2. Usando Gradle (Línea de Comandos)

```bash
gradle test
```

### 3. Usando Tags (Línea de Comandos)

```bash
gradle test -Dcucumber.filter.tags=@nombre_del_tag
```

### 4. Generar Reportes

```bash
gradle generateCucumberReport
```

## 🔄 Integración Continua (CI/CD)

El proyecto incluye un pipeline automatizado con GitHub Actions que se ejecuta automáticamente en cada push y pull
request:

- ✅ Ejecución automática de pruebas
- ✅ Generación de reportes
- ✅ Captura de screenshots en fallos
- ✅ Notificaciones de estado

## 📋 Requisitos

- Java Development Kit (JDK) versión 8 o superior
- Gradle instalado globalmente

## 🔧 Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/zagui-master/reto-tecnico-abstracta
   ```

2. Navega al directorio del proyecto:
   ```bash
   cd reto-tecnico-abstracta
   ```

3. Instala las dependencias:
   ```bash
   gradle build
   ```

## 🤝 Contribuir

1. Haz fork del proyecto
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`)
3. Realiza tus cambios
4. Confirma tus cambios (`git commit -am 'Agregar nueva característica'`)
5. Sube tu rama (`git push origin feature/nueva-caracteristica`)
6. Crea un pull request en GitHub