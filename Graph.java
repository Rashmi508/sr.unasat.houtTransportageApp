package sr.unasat.A.D;

public class Graph {

    private final int MAX_POSTEN = 10;
    private final int INFINITY = 1000000;
    private VeldPost vertexList[];
    private int adjMat[][];
    private int nVeldPosten;
    private int nTree;
    private WeightParent sPath[];
    private int currentPost;
    private int startToCurrent;
    private Stack s;
    private Queue q;

    private final int INFINITE = 0;
    private WeightParent lPath[];


    public Graph() {
        vertexList = new VeldPost[MAX_POSTEN];
        adjMat = new int[MAX_POSTEN][MAX_POSTEN];
        nVeldPosten = 0;
        nTree = 0;

//        for (int j = 0; j < MAX_POSTEN; j++)
//            for (int k = 0; k < MAX_POSTEN; k++)
//                adjMat[j][k] = INFINITY;  // geeft aan dat er in het begin geen edges geregistreerd zijn.

        for(int j = 0; j < MAX_POSTEN; j++)
            for (int k = 0; k < MAX_POSTEN; k++)
                adjMat[j][k] = INFINITE;

        s = new Stack();
        q = new Queue();
        sPath = new WeightParent[MAX_POSTEN];
        lPath = new WeightParent[MAX_POSTEN];
    }

    public void addVeldPost(String lab) {
        vertexList[nVeldPosten++] = new VeldPost(lab);
    }

//    public void addEdge(int start, int end) {
//        adjMat[start][end] = 1;
//    }

    public void displayVeldPost(int v) {
        System.out.print(vertexList[v].label + " - ");
    }

    public int getAdjUnvisitedPost(int v) {
        for (int j = 0; j < nVeldPosten; j++) {
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
                return j;
            }
        }
        return -1;
    }

    public void dfs() {

        vertexList[0].wasVisited = true;
        displayVeldPost(0);
        s.push(0);

        while(!s.isEmpty()) {                       // zolang de stack niet leeg is, gaat het loopen en visiten.
            int v = getAdjUnvisitedPost(s.peek());

            if(v == -1) {
                s.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVeldPost(v);
                s.push(v);
            }
        }

        for (int j = 0; j < nVeldPosten; j++)
            vertexList[j].wasVisited = false;
    }


    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVeldPost(0);
        q.insert(0);
        int vert2;

        while(!q.isEmpty()) {
            int vert1 = q.remove();
            while((vert2=getAdjUnvisitedPost(vert1)) != -1) {
                vertexList[vert2].wasVisited = true;
                displayVeldPost(vert2);
                q.insert(vert2);
            }
        }

        for (int j = 0; j < nVeldPosten; j++)
            vertexList[j].wasVisited = false;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public void addEdge (int start, int end, int weight) {
        adjMat[start][end] = weight;
    }

//    public void cheapestpath(int start){
//
//        int startTree = start;  //begint dus waar aangegeven is.
//        vertexList[startTree].isInTree = true;
//        nTree = 1;
//
//
//        for(int j=0; j<nVeldPosten; j++) {  // itereren over aantal vertices.
//            int tempW= adjMat[startTree][j];
//            sPath[j] = new WeightParent(startTree, tempW);
//        }
//
//        while(nTree < nVeldPosten) {
//            int indexMin = getMin();    //haalt min uit sPath.
//            int minDist = sPath[indexMin].weight;
//
//            if(minDist == INFINITY)
//            {
//                System.out.println("De vertices zijn onbereikbaar");
//                break;
//            }
//            else
//            {
//                currentPost = indexMin;
//                startToCurrent = sPath[indexMin].weight;  //distance van parent tot closest vert.
//            }
//
//            vertexList[currentPost].isInTree = true;
//            nTree++;
//
//            adjust_sPath();
//        }
//
//        displayPaths(); //gaat de sPath conents tonen.
//        nTree = 0;
//        for(int j=0; j < nVeldPosten; j++)
//            vertexList[j].isInTree = false;
//    }
//
//    public int getMin() {
//        int minDistance = INFINITY;
//        int indexMin = 0;
//
//        for(int j=1; j<nVeldPosten; j++){
//
//            if( !vertexList[j].isInTree && sPath[j].weight < minDistance ){
//                minDistance = sPath[j].weight;
//                indexMin = j;
//            }
//        }
//        return indexMin;
//
//    }
//
//    public void adjust_sPath() {
//        int column = 1;
//        while(column < nVeldPosten)
//
//        {
//
//            if( vertexList[column].isInTree )
//            {
//                column++;
//                continue;
//            }
//
//            int currentToFringe = adjMat[currentPost][column]; //current vert na die kolom.
//
//            int startToFringe = startToCurrent + currentToFringe; //claculatie van de vorige naar de huidige.
//
//            int sPathDist = sPath[column].weight;
//
//            if(startToFringe < sPathDist)
//            {
//
//                sPath[column].parentVert = currentPost;
//                sPath[column].weight = startToFringe; //distance van current vert.
//            }
//            column++;
//        }
//    }
//
////    public int findIndexOf (String veldpost) {  //zoekt naar je index van de startpunt d.m.v een string.
////        int userGiven;
////        for (userGiven = 0; userGiven < nVeldPosten; userGiven++) {
////            if (vertexList[userGiven].label.equalsIgnoreCase(veldpost))
////                return userGiven;
////        }
////        return userGiven;
////    }
//
//
//
//    public void displayPaths() {
//        for(int j=0; j<nVeldPosten; j++) {
//            System.out.print(vertexList[j].label + "=");
//
//            if(sPath[j].weight == INFINITY)
//                System.out.print("0");
//
//            else
//                System.out.print(sPath[j].weight);
//
//            String parent = vertexList[ sPath[j].parentVert].label;
//            System.out.print(" <-- " + parent + ", ");
//        }
//        System.out.println("");
//    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public void expensivePath(int start) {

        int startTree = start;
        vertexList[startTree].isInTree = true;
        nTree = 1;


        for (int j = 0; j < nVeldPosten; j++) {
            int tempW = adjMat[startTree][j];
            lPath[j] = new WeightParent(startTree, tempW);
        }

        while (nTree < nVeldPosten) {
            int indexMax = getMax();
            int maxDist = lPath[indexMax].weight;

            if (maxDist == INFINITE) {

                System.out.println("De vertices zijn onbereikbaar");
                break;

            } else {
                currentPost = indexMax;
                startToCurrent = lPath[indexMax].weight;

            }

            vertexList[currentPost].isInTree = true;
            nTree++;
            adjust_lPath_longest();
        }

        displayPaths();
        nTree = 0;
        for (int j = 0; j < nVeldPosten; j++)
            vertexList[j].isInTree = false;
    }


    public int getMax() {
        int maxDist = INFINITE;
        int indexMax = 0;

        for (int j = 1; j < nVeldPosten; j++) {
            if (!vertexList[j].isInTree && lPath[j].weight > maxDist) {
                maxDist = lPath[j].weight;
                indexMax = j;
            }
        }
        return indexMax;
    }


    public void adjust_lPath_longest() {
        int column = 1;
        while (column < nVeldPosten) {

            if (vertexList[column].isInTree) {
                column++;
                continue;
            }


            int currentToFringe = adjMat[currentPost][column];


            int startToFringe = startToCurrent + currentToFringe;


            int sPathDist = lPath[column].weight;


            if (startToFringe > sPathDist && currentToFringe != 0) {

                lPath[column].parentVert = currentPost;
                lPath[column].weight = startToFringe;
            }
            column++;
        }
    }


    public void displayPaths() {
        for (int j = 0; j < nVeldPosten; j++) {
            System.out.print(vertexList[j].label + "=");
            if (lPath[j].weight == INFINITE)
                System.out.print("0");

            else
                System.out.print(lPath[j].weight);

            String parent = vertexList[lPath[j].parentVert].label;
            System.out.print(" (" + parent + "), ");

        }
        System.out.println("");
    }

    public int findIndexOf (String veldpost) {  //zoekt naar je index van de startpunt d.m.v een string.
        int userGiven;
        for (userGiven = 0; userGiven < nVeldPosten; userGiven++) {
            if (vertexList[userGiven].label.equalsIgnoreCase(veldpost))
                return userGiven;
        }
        return userGiven;
    }

}



