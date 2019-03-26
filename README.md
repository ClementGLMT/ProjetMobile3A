# **LES CHATS**

## Présentation

Ce projet est un exemple d'utilisation d'une Recycler Viewt. Les données chargées à l'intérieur de cette liste sont chargées depuis une API (utilisation de Retrofit) et sont stockées en cache (utilisation de SharedPreferences). Une architecture MVM a été adoptée et des transitions ont été mises en place entre les écrans (utilisation d'Animatoo).

Cette application affiche la liste de chats présente sur l'API créée par mes soins (chats existants et fictifs : https://clementguillemaut.github.io/cat.json )

## Prérequis


- Installation d'Android Studio
- Récupérer la branche develop<br/>


## Consignes respectées : 

- Architecture MVC
- Appels REST
- Ecrans : 2 activities
- Affichage d'une liste dans un RecyclerView (1 ImageView et 2 TextView)
- Affichage du détail d'un item de la liste (1 ImageView et 7 TextView)
- Gitflow 
- Stockage des données en cache (SharedPreferences)
- Animations (Animatoo)

### Présentation de l'API réalisée :

Voici le format d'une réponse de la catAPI (seulement 2 chats à titre d'exemple) : 

```bash
{
  "results": [
    {
    "cat_pic": "https://chat-de-race.fr/wp-content/uploads/2017/06/scottishfold-chat-blanc-gris.jpg",
    "cat_name": "Kiki",
    "cat_age": "2",
    "cat_mood": "Vilain",
    "cat_color": "Gris",
    "cat_num": "0633055054",
    "cat_height": "25",
    "cat_coat": "Doux"
    },
     {
     "cat_pic": "https://i.pinimg.com/originals/28/7d/47/287d476e21403c4a0459102c404cc361.jpg",
     "cat_name": "Zouzou",
     "cat_age": "5",
     "cat_mood": "Mignon",
     "cat_color": "Roux, noir, blanc",
     "cat_num": "0605438745",
     "cat_height": "22",
     "cat_coat": "Doux"
    }
   ]
}
```

## Fonctionnalités: 

### 1ère activity : 

Liste des chats : 

<img src="https://image.noelshack.com/fichiers/2019/13/2/1553617661-55529868-261977718017237-3811347042098216960-n.jpg" alt="act1" width="200" height="422>

### 2ème activity :  

- Détail du chat : 

<img src="https://image.noelshack.com/fichiers/2019/13/2/1553617916-54798082-378998912687342-7830373499762900992-n.jpg" alt="act2">
