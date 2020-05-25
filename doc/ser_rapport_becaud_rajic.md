# HEIG-VD - SER - Rapport Laboratoire 3 - GeoJSON à KML
## Authors
Arthur Bécaud et Nenad Rajic
## Classes Java
Le projet se compose de deux classes ( `GeoJSONReader` et `KMLWriter` ) pour _parser_ les données, de trois autres classes pour stocker les données GeoJSON en mémoire ( `Country`, `Polygon` et `Coordinate` ) et d'une interface pour permettre au trois classes précédentes de générer elle-même leur format KML ( `FormattableToKML` ).

En plus de cela s'ajoute des classes de test pour vérifier le fonctionnement du projet et une classe `Main` pour utiliser les _parsers_.
### Classes de stockage de données
#### Coordinate
La classe `Coordinate` permet de stocker deux coordonnées x y d'un plan à deux axes.
#### Polygon
La classe `Polygon` permet de stocker une liste de coordonnées pour former un polygone.
#### Country
La classe `Country` permet de stocker un nom _admin_, une abréviation _iso_a3_ et un polygone formant les bordures d'un pays.
### Interface FormattableToKML
L'interface `FormattableToKML` comprend une méthode `toKML()` retournant une instance `org.jdom2.Element`. Cette méthode permet à une classe de se formater elle même  à un format KML et d'en retourner le résultat.
### Parser
#### GeoJSONReader

#### KMLReader
**-- TODO --**
## Difficultés rencontrées
**-- TODO --**
## Problèmes connues
**-- TODO --**
## Résultat du _parsing_ du fichier GeoJSON
**-- TODO --**
## Résultat sur Google Earth
**-- TODO --**
## _Apprentissages ?_
**-- TODO --**
## Conclusions
**-- TODO --**
