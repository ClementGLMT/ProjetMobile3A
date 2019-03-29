# **LES CHATS**


## Présentation

Ce projet est un exemple d'utilisation d'une Recycler View. Les données chargées à l'intérieur de cette liste sont chargées depuis une API (utilisation de Retrofit) et sont stockées en cache (utilisation de SharedPreferences). Une architecture MVM a été adoptée et des transitions ont été mises en place entre les écrans (utilisation d'Animatoo).

Cette application affiche la liste de chats présente sur l'API créée par mes soins 
(chats existants et fictifs : https://clementguillemaut.github.io/cat.json )


## Prérequis


- Installation d'Android Studio
- Récupérer la branche develop<br/>


## Consignes respectées : 


- Architecture MVC
- Appels REST
- 3 Activities : 
    - Splashscreen
    - Affichage de la liste
    - Détail de l'item clické
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

### Splashscreen : 


<img src="https://image.noelshack.com/fichiers/2019/13/5/1553858289-55750447-417128005730053-562408547023847424-n.jpg" alt="act1" width="300" height="633">


### 1ère activity : 


Liste des chats : 


<img src="https://image.noelshack.com/fichiers/2019/13/3/1553697933-53884366-557114861445263-5115275817261203456-n.jpg" alt="act1" width="300" height="633">


### 2ème activity :  


Détail du chat : 


<img src="https://image.noelshack.com/fichiers/2019/13/3/1553697940-55795240-787250864974776-679987026258296832-n.jpg" alt="act2" width="300" height="633">

