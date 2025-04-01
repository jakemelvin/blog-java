Documentation de l'API Blog
Description
Cette API fournit des fonctionnalités pour gérer des articles et des commentaires sur un blog. Elle permet la création, la récupération, la mise à jour et la suppression d'articles, ainsi que l'ajout et la suppression de commentaires.

Prérequis
Java 17

PostgreSQL

Maven

Configuration
Clonez le dépôt :

```

git clone <URL_DU_REPO>

cd <NOM_DU_PROJET>

```

Configurez la base de données :

Assurez-vous que PostgreSQL est installé et en cours d'exécution.

Créez une base de données nommée blog_db.

Mettez à jour le fichier application.properties avec les détails de votre base de données :

```
spring.datasource.url=jdbc:postgresql://localhost:5432/blog_db
spring.datasource.username=postgres
spring.datasource.password=Ines@2023
spring.datasource.driver-class-name=org.postgresql.Driver
```

Construisez et exécutez l'application :

```
mvn spring-boot:run
```

L'application sera accessible à l'adresse http://localhost:9000.

API Endpoints
Tous les endpoints sont préfixés par /api/v1.

Articles
Créer un article

Endpoint : POST /api/v1/articles/create

Description : Crée un nouvel article.

Requête :

```
{
"title": "Titre de l'article",
"content": "Contenu de l'article"
}
```

Paramètres :

title (chaîne, obligatoire) : Titre de l'article.

content (chaîne, obligatoire) : Contenu de l'article.

Réponse :

```
{
"message": "Article created successfully",
"data": {
"id": 1,
"title": "Titre de l'article",
"content": "Contenu de l'article",
"createdAt": "2024-07-24T10:00:00",
"updatedAt": "2024-07-24T10:00:00"
}
}
```

Récupérer tous les articles

Endpoint : GET /api/v1/articles

Description : Récupère tous les articles.

Réponse :

```
{
"message": "Articles fetched successfully",
"data": [
{
"id": 1,
"title": "Titre de l'article 1",
"content": "Contenu de l'article 1",
"createdAt": "2024-07-24T10:00:00",
"updatedAt": "2024-07-24T10:00:00"
},
{
"id": 2,
"title": "Titre de l'article 2",
"content": "Contenu de l'article 2",
"createdAt": "2024-07-24T11:00:00",
"updatedAt": "2024-07-24T11:00:00"
}
]
}
```

Récupérer un article par ID

Endpoint : GET /api/v1/articles/get-by

Description : Récupère un article par son ID.

Paramètres de requête :

articleId (entier, obligatoire) : ID de l'article à récupérer.

Réponse :

```
{
"message": "Article found",
"data": {
"id": 1,
"title": "Titre de l'article",
"content": "Contenu de l'article",
"createdAt": "2024-07-24T10:00:00",
"updatedAt": "2024-07-24T10:00:00"
}
}
```

Mettre à jour un article

Endpoint : PUT /api/v1/articles/update

Description : Met à jour un article existant.

Paramètres de requête :

articleId (entier, obligatoire) : ID de l'article à mettre à jour.

Requête :

```
{
"title": "Nouveau titre de l'article",
"content": "Nouveau contenu de l'article"
}
```

Paramètres :

title (chaîne, obligatoire) : Nouveau titre de l'article.

content (chaîne, obligatoire) : Nouveau contenu de l'article.

Réponse :

```
{
"message": "Article updated successfully",
"data": {
"id": 1,
"title": "Nouveau titre de l'article",
"content": "Nouveau contenu de l'article",
"createdAt": "2024-07-24T10:00:00",
"updatedAt": "2024-07-24T12:00:00"
}
}
```

Supprimer un article

Endpoint : DELETE /api/v1/articles/delete

Description : Supprime un article par son ID.

Paramètres de requête :

articleId (entier, obligatoire) : ID de l'article à supprimer.

Réponse :

```
{
"message": "Article deleted successfully",
"data": null
}
```

Commentaires
Ajouter un commentaire à un article

Endpoint : POST /api/v1/comments/create

Description : Ajoute un commentaire à un article.

Paramètres de requête :

articleId (entier, obligatoire) : ID de l'article auquel ajouter le commentaire

Requête :

```
{
"text": "Contenu du commentaire"
}
```

Paramètres :

text (chaîne, obligatoire) : Le contenu du commentaire

Réponse :

```
{
"message": "Comment added successfully",
"data": {
"id": 1,
"articleId": 1,
"text": "Contenu du commentaire",
"createdAt": "2024-07-24T13:00:00",
"updatedAt": "2024-07-24T13:00:00"
}
}
```

Supprimer un commentaire

Endpoint : DELETE /api/v1/comments/delete

Description : Supprime un commentaire par son ID.

Paramètres de requête :

commentId (entier, obligatoire) : ID du commentaire à supprimer.

Réponse :

```
{
"message": "Comment deleted successfully",
"data": null
}
```

Utilisation
Vous pouvez utiliser n'importe quel client HTTP (comme Postman, Insomnia, curl) pour interagir avec cette API. Voici quelques exemples utilisant curl :

Créer un article :

```
curl -X POST 

http://localhost:9000/api/v1/articles/create 

-H 'Content-Type: application/json' 

-d '{
"title": "Mon Nouvel Article",
"content": "Ceci est le contenu de mon nouvel article."
}'
```

Récupérer tous les articles :

```
curl http://localhost:9000/api/v1/articles
```

Récupérer un article par ID :

```
curl http://localhost:9000/api/v1/articles/get-by?articleId=1
```

Mettre à jour un article :

```
curl -X PUT 

http://localhost:9000/api/v1/articles/update?articleId=1 

-H 'Content-Type: application/json' 

-d '{
"title": "Article Mis à Jour",
"content": "Ceci est le contenu mis à jour de mon article."
}'
```

Supprimer un article :

```
curl -X DELETE http://localhost:9000/api/v1/articles/delete?articleId=1
```

Ajouter un commentaire :

```
curl -X POST 

http://localhost:9000/api/v1/comments/create?articleId=1 

-H 'Content-Type: application/json' 

-d '{
"text": "Ceci est un commentaire sur l'article."
}'
```

Supprimer un commentaire :

```
curl -X DELETE  http://localhost:9000/api/v1/comments/delete?commentId=1
```

Erreurs
L'API renvoie des codes d'état HTTP standard pour indiquer le succès ou l'échec d'une requête. En cas d'erreur, la réponse contiendra également un message d'erreur au format JSON :

```
{
"message": "Message d'erreur"
}
```
