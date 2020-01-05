package main;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        /*
        L'utilisation du programme via l'objet Facade, permet de :
            - Créer un graphe à partir d'un complexe généré via seed
            - Afficher les tableaux des question 8 et 9 en variant les bornes et le nombre d'essaies

         Dans tous les cas, il est possible d'obtenir depuis le Graph :
            - Une image de visualisation (fonction image(String filename) de Graph)
            - Obtenir le nombre d'arêtes k (fonction getK())
            - Obtenir le delta minimum du graphe (fonction getDelta())
            - Manipuler les Edges (via le getEdges())
            - Manipuler le Complexe (et ses sous complexes) via l'attribut 'initial' du graphe
         */

        ////// Exemples d'actions possibles ////////

        /**
         * Créer un graphe (avec un complexe généré via la seed 1665 pour p=3 et t=4) en utilisant l'algorithme 1
         * si la visualisation est activé, une image est crée permettant de voir le graphe créé
         *
         * Algo peut etre 1 ou 2 (pour 1 ici)
         * Seed obligatoire (car pas pertinent sans seed) mais possibilité de passer 'new Random().nextInt()" au lieu de 1665
         * Si Visualisation est True, l'URI de celle-ci est affichée dans le terminal
         */
          // Graph graph = Facade.singleGraphe(3, 4, 1, 1665, true);


        /**
         * Affiche les 6 tableaux des questions 8 et 9
         *
         * En prenant en compte :
         *  - Nombre de générations/essaies : 5 000
         *
         *  - Borne K min = 150
         *  - Borne K max = 350 (de 10 en 10)
         *
         *  - Borne Delta min = 7
         *  - Borne Delta max = 16 (de 1 en 1)
         *
         *  - Graphe construit via l'algorithme = 1
         *
         *  (ces paramètres sont ceux employés pour les données dans le rapport)
         *
         *  Nous construisons la solution la plus optimal (de l'algorithme) pour 1 problème donné
         *  puis nous regardons parmis toutes les solutions obtenues à partir des N générations aléatoires
         *  combien on un K et un Delta inférieur ou égal à la valeur du tableau f(K, D)
         */
        //Facade.printTableaux(5000, 150, 350, 7, 16, 1);


        // Idem au-dessus
        // Graph graph = Facade.singleGraphe(3, 4, 1, 1665, false);

        // Affiche toutes les Edges du Graph dans le terminal
        // graph.printGraph();

        // Récupère le complexe du graphe
        // Complexe complexe = graph.initial;

        // Récupère toutes les arêtes du graphe
        // List<Edge> edges = graph.edges;
    }

}
