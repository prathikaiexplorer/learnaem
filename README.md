# LearnAEM

Personal AEM learning sandbox using **AEM as a Cloud Service** best practices.

## Project Info
- Archetype: `aem-project-archetype` v53
- AEM Version: AEM as a Cloud Service (cloud)
- Java: 21
- Maven: 3.9+

## Module Structure
| Module | Description |
|---|---|
| `core` | OSGi bundles — Java code, Sling Models, OSGi services |
| `ui.apps` | Component definitions, HTL templates, dialogs, clientlibs |
| `ui.content` | Sample content, page templates, editable template policies |
| `ui.config` | OSGi configurations per runmode |
| `ui.frontend` | Frontend build (Webpack/npm) |
| `dispatcher` | Dispatcher configuration |
| `all` | Embed all packages into a single deployable package |
| `analyse` | Analyse the `all` package with AEM Analyser |

## Build
```bash
# Full build + deploy to local AEM SDK
mvn clean install -PautoInstallSinglePackage

# Build only (no deploy)
mvn clean install
```

## Branch Strategy
| Branch | Description |
|---|---|
| `main` | Baseline Maven scaffold |
| `phase-1/simple-component` | Simple AEM component — HTL + dialog + Sling Model |

## Prerequisites
- Java 21 (mandatory for AEMaaCS SDK as of Feb 2026)
- Maven 3.9+
- AEM SDK (AEM as a Cloud Service QuickStart JAR)
