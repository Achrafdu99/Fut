# Système de Gestion d'Équipes de Football

## Description
Ce projet, dans le cadre de l'UE Développement comp. log. de Monsieur Saidi au Master MIAGE de Nice, implémente un système de gestion pour les équipes de football, utilisant une architecture basée sur des microservices. Chaque service est spécialisé dans une fonctionnalité distincte et communique via Eureka.
## Statut du Projet
Le projet est en cours de développement. Des corrections et améliorations sont prévues pour enrichir l'expérience d'apprentissage et profiter pleinement du cours.
## Microservices
- **EurekaServer** : Fournit la découverte de service pour tous les microservices.
- **TeamService** : Gère les opérations CRUD pour les équipes de football.
- **PlayerService** : Responsable de la gestion des joueurs.
- **MatchService** : Gère les informations relatives aux matchs de football.
- **StatsService** : Fournit des statistiques sur les équipes et les joueurs.

## Technologies et Outils
- Spring Boot (v3.2.1)
- Spring Cloud (v2023.0.0)
- Eureka pour la découverte de services
- Ribbon pour l'équilibrage de charge
- Circuit Breaker pour la tolérance aux pannes
- Swagger pour la documentation des API
- Actuator pour le monitoring
- PostgreSQL pour la persistance des données
- Lombok pour réduire le code boilerplate
- Docker et Kubernetes pour la conteneurisation et le déploiement

## Fonctionnalités Clés
- Communication entre les services via Eureka
- Documentation API avec Swagger
- Gestion de la tolérance aux pannes avec Circuit Breaker
- Monitoring avec Spring Boot Actuator
- Déploiement sur Kubernetes

## Dépendances par Service
Chaque microservice utilise un ensemble de dépendances Maven pour implémenter ses fonctionnalités.

