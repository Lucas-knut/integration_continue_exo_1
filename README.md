# Exercice 1 — Environnement CI avec Jenkins, Maven & Git

Mise en place d'un environnement d'intégration continue conteneurisé via Docker Compose.

## Stack technique

| Outil | Version |
|---|---|
| Image de base | Ubuntu 22.04 LTS |
| Git | 2.34+ |
| OpenJDK | 21 |
| Jenkins | LTS |
| Apache Maven | 3.9.6 |
| Conteneurisation | Docker / Docker Compose |

## Structure du projet

```
exo1/
├── Dockerfile          # Image custom basée sur ubuntu:22.04 avec Jenkins, Maven & Git
├── docker-compose.yml  # Définition de la stack
└── README.md
```

## Prérequis

- [Docker](https://docs.docker.com/engine/install/) installé
- [Docker Compose](https://docs.docker.com/compose/install/) v2+

## Démarrage

### 1. Construire et lancer la stack

```bash
docker compose up -d --build
```

### 2. Accéder à Jenkins

Ouvrir [http://localhost:8080](http://localhost:8080) dans un navigateur.

### 3. Récupérer le mot de passe administrateur initial

```bash
docker exec jenkins cat /var/lib/jenkins/secrets/initialAdminPassword
```

Coller ce mot de passe dans l'interface web pour terminer la configuration initiale.

## Ports exposés

| Port | Usage |
|---|---|
| `8080` | Interface web Jenkins |
| `50000` | Communication avec les agents Jenkins (JNLP) |

## Persistance des données

Un volume Docker nommé `jenkins_home` est monté sur `/var/jenkins_home` afin de conserver :
- les jobs et pipelines configurés
- les plugins installés
- les credentials et la configuration globale

Les données survivent à un redémarrage ou à une recréation du conteneur.

## Commandes utiles

```bash
# Arrêter la stack
docker compose down

# Arrêter et supprimer les volumes (reset complet)
docker compose down -v

# Voir les logs Jenkins en temps réel
docker compose logs -f jenkins

# Vérifier les versions dans le conteneur
docker exec jenkins git --version
docker exec jenkins mvn --version
docker exec jenkins java --version
```
