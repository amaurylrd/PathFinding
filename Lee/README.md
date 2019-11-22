﻿# Maze Path Finding Lee Algorithm

Encapsule l'ensemble des sources qui forment une application java de recherche de chemin.

## Description

L'utilisateur dispose d'une grille sur laquelle ont été disposé arbitrairement en dure un point de départ et un point d'arrivé. Il peut à l'aide du clic droit placer et retirer à discrétion des "murs", soit bloquer des zones de sorte que l'application ait l'apparence d'un labyrinthe. On peut en se jouant distinguer un mur d'une case asseptisé grâce à leur couleur de fond. Aussi disponible, le clic gauche, déclanche quant à lui la recherche d'un chemin le plus court et l'affiche. On peut redémarrer l'exercice, en cliquant à nouveau.

## Explication - Algortithme de Lee

L'algorithme de Lee est une solution possible pour trouver le plus court chemin basée sur une recherche en profondeur (la recherche s'expand en vagues). Il donne toujours une solution optimale, si elle existe, mais elle est lente et sa complexité est considérable.

### Initialisation

Notre point de départ porte la valeur 0. Ici, il est toujours à la même place en (0, 0). On amorce l'algorithme avec la valeur k d'itération de la vague (0 pour la première) et des coordonées (i, j)

### Propagation

A la case corresponte on parse les noeux voisins et on leur assigne comme valeur k+1 si
- ce n'est pas la case de départ
- ce n'est pas un mur
- ce n'est pas une case déjà balisé
- ce n'est pas la case finale

Dès lors, on modifie l'apparence et les attributs des voisins puis, on calcule cmp le nombre total d'étiquettes k et pour chaque case qui a cette signature, on :
- regarde le voisinage
- décrémente cmp
- incrémente k lorsque cmp est rendu à 0

### Backtrace et affichage

La case finale atteinte, on retrouve récursivement quel chemin maintient la suite de k ordonnée et on l'affiche !
