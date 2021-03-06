package solver;

import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import java.io.IOException;

public class WordJumpSolver {

    public static void jumpToWord(String begin, String jumpTo) throws IOException {
        WordDistanceGraph wordDistanceGraph = new WordDistanceGraph();
        DijkstraShortestPath<String, DefaultEdge> shortestPath = new DijkstraShortestPath<>(wordDistanceGraph.buildGraph(begin.length()));
        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultEdge> pathToJump = shortestPath.getPaths(begin);
        System.out.println(pathToJump.getPath(jumpTo));
    }

    public static int findSubsitutionDistance(String first, String second){
        if (first.length() != second.length()){
            return -1;
        }else if (first.equalsIgnoreCase(second)){
            return 0;
        }
        else{
            int distance = 0;
            for (int i = 0; i < first.length(); i++){
                if (first.charAt(i) != second.charAt(i)){
                    distance++;
                }
            }
            return distance;
        }
    }
}
