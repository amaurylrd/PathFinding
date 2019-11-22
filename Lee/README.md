# Maze Path Finding Lee Algorithm

Encapsule l'ensemble des sources qui forment une application java de recherche de chemin.

## Description

L'utilisateur peut avec clic droit placer ou retirer à discrétion des "murs" et ainsi construire son labyrinthe. Le clic gauche déclanchera la recherche d'un chemin le plus court et l'affiche.

On peut redémarrer la simulation, en cliquant.

## Explication - Algortithme de Lee

L'algorithme de Lee est une solution pour trouver le plus court chemin basée sur une recherche en profondeur (la recherche s'expand en vagues). Il donne toujours une solution optimale, si elle existe, mais elle est lente (sa complexité est considérable).

### Initialisation

On place à point de départ et un point d'arrivée. Le point de départ a la valeur 0.
Soient k=0, le nombre d'itérations et des coordonées (i, j).

### Propagation

On parse les noeuds voisins et on leur assigne comme valeur k+1 si et seulement si
- ce n'est pas la case de départ ;
- ce n'est pas un mur ;
- ce n'est pas une case déjà balisé ;
- ce n'est pas la case finale.

On calcule cmp le nombre total d'étiquettes k et pour chaque case qui a cette signature, on :
- regarde le voisinage ;
- décrémente cmp ;
- incrémente k lorsque cmp est 0.

### Backtrace et affichage

La case finale atteinte, on retrouve récursivement quel chemin maintient la suite ordonnée de k.
