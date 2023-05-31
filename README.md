# 4irc-ASI-Buchaille-Llop-Chaduc-Medard
#### 4irc-ASI-Buchaille-Llop-Chaduc-Medard

Il existe deux environnements de travail :
 - [Développement](#developpement)
 - [Production](#production)

# Developpement

L'envirronement de développement n'utilise pas les docker 
pour les service, chaque service est lancé à part mais tous
les services sont lancés avec la même base de données.

Il faut donc lancer le docker de la base de données.

## Base de donnée

```shell
docker run -d -p 3306:3306 --name mysql-asi -e MYSQL_ROOT_PASSWORD=toto -e MYSQL_DATABASE=database  mysql:latest
```

## Back

Ensuite chaque service doit être lancé à part.

Des configurations pour IntelliJ sont disponibles dans le
dossier `.run`.

## Documentation

Une documentation Swagger est disponible sur la route /docs

## Spécificité

Lors du lancement en mode développement, les requêtes ne sont
pas authentifiées auprès du authentication-service.

# Production

L'environnement de production utilise les docker pour chaque
service, base de données et aussi pour le reverse proxy.

Il suffit donc de lancer le docker-compose.

```shell
docker-compose up -d
```

## Documentation

Une documentation Swagger est disponible pour chaque service 
sur les routes:
 - /api/user/docs
 - /api/authentication/docs
 - /api/game/docs
 - /api/card/docs

## Spécificité

Lors du lancement en mode production, les requêtes sont
authentifiées auprès du authentication-service.