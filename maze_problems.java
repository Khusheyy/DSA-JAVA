import java.util.ArrayList;
import java.util.Arrays;

public class maze_problems {
    public static void main(String[] args) {
        //System.out.println(count(3,3));
        //path("",3,3);
        //System.out.println(pathret("",3,3));
        //System.out.println(pathretdiagonal("",3,3));
        boolean[][] board = new boolean[][]{
            {true,true,true},
            {true,true,true},
           {true,true,true}
        };

        int[][] path = new int[board.length][board[0].length];
        //pathRestriction("",board,0,0);
        //backtracking("",board,0,0);
        allpathPrint("",board,0,0,path,1);
    }


    static int count(int row,int col){
        if(row==1 || col==1){
            return 1;
        }

        int left=count(row-1,col);
        int right=count(row,col-1);
        return left + right;
    }
    static void path(String p,int r,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1){
            path(p+"D",r-1,c);
        }
        if(c>1){
            path(p+"R",r,c-1);
        }
    }

    //retruning via araaylist
    static ArrayList<String> pathret(String p,int r,int c){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        if(r>1){
            list.addAll(pathret(p+"D",r-1,c));
        }
        if(c>1){
            list.addAll(pathret(p+"R",r,c-1));
        }
        return list;
    }

    static ArrayList<String> pathretdiagonal(String p,int r,int c){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        if(r>1 && c>1){
            list.addAll(pathretdiagonal(p+"D",r-1,c-1));
        }

        if(r>1){
            list.addAll(pathretdiagonal(p+"V",r-1,c));
        }
        if(c>1){
            list.addAll(pathretdiagonal(p+"H",r,c-1));
        }
        return list;
    }

    static void pathRestriction(String p,boolean[][] maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r<maze.length-1){
            pathRestriction(p+"D",maze,r+1,c);
        }
        if(c<maze[0].length-1){
            pathRestriction(p+"R",maze,r,c+1);
        }
    }


    static void allpath(String p,boolean[][] maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r<maze.length-1){
            allpath(p+"D",maze,r+1,c);
        }
        if(c<maze[0].length-1){
            allpath(p+"R",maze,r,c+1);
        }
        if(r>0){
            allpath(p+"u",maze,r-1,c);

        }
        if(c>0){
            allpath(p+"L",maze,r,c-1);

        }
    }//this code shows us stack overflow error kyuki this is infinite recursion which is never ending


    static void backtracking(String p,boolean[][] maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }

        //i have visited this cell so now i will mark it as false
        maze[r][c]=false;//make a change
        if(r<maze.length-1){
            backtracking(p+"D",maze,r+1,c);
        }
        if(c<maze[0].length-1){
            backtracking(p+"R",maze,r,c+1);
        }
        if(r>0){
            backtracking(p+"U",maze,r-1,c);
        }
        if(c>0){
            backtracking(p+"L",maze,r,c-1);
        }

        // this is the last line of the funaction and the function will get over here
        // now i change back all the changes that were made in this function call
        maze[r][c]=true;//revert the change


        //you wanna check that what if you did not take this path then that
        // path must not be marked visited,,,,
        //now that since this particular cell is being removed from the path please also remove the history of this path
    }
    static void allpathPrint(String p,boolean[][] maze,int r,int c,int[][] path,int step){
        if(r==maze.length-1 && c==maze[0].length-1){
            path[r][c] = step;
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c]){
            return;
        }

        maze[r][c]=false;
        path[r][c]= step;

        if(r<maze.length-1){
            allpathPrint(p+"D",maze,r+1,c,path,step+1);
        }
        if(c<maze[0].length-1){
            allpathPrint(p+"R",maze,r,c+1,path,step+1);
        }
        if(r>0){
            allpathPrint(p+"U",maze,r-1,c, path,step+1);

        }
        if(c>0) {
            allpathPrint(p + "L", maze, r, c - 1, path, step + 1);
        }

        maze[r][c]=true;
        path[r][c]=0;

    }
}
