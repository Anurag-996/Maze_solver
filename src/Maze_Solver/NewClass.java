package Maze_Solver;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class NewClass extends JFrame {
    private int[][]maze =
                            {{1,1,1,1,1,1,1,1},
                            {1,0,1,0,1,0,0,1},
                            {1,0,1,1,0,1,1,1},
                            {1,0,0,1,0,1,1,1},
                            {1,0,1,1,0,0,0,1},
                            {1,0,0,0,1,0,0,1},
                            {1,1,1,0,0,0,9,1},
                            {1,1,1,1,1,1,1,1}};
    public List<Integer> path = new ArrayList<>();

    public NewClass(){
        setTitle("Maze Solver");
        setSize(800,630);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirstSearch.searchpath(maze,1,1,path);
        System.out.println(path);
    }
    @Override
    public void paint(Graphics g){
        g.translate(200,100);
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                Color color;
                switch(maze[i][j]){
                    case 1: color=Color.BLACK;break;
                    case 9: color=Color.RED;break;
                    default : color=Color.WHITE;break;
                }

                g.setColor(color);
                g.fillRect(50*j,50*i,50,50);
                g.setColor(Color.red);
                g.drawRect(50*j,50*i,50,50);
            }
        }
        for(int i=0;i<path.size();i+=2){
            int pathx = path.get(i);
            int pathy = path.get(i+1);

            System.out.println("X coordinates"+pathx);
            System.out.println("Y coordinates"+pathy);

            g.setColor(Color.GREEN);
            g.fillRect(50*pathx,50*pathy,50,50);
        }
    }

    public static void main(String[] args) {
        NewClass view = new NewClass();
        view.setVisible(true);
    }
}
