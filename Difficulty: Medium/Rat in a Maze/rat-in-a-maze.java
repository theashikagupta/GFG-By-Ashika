class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int row=maze.length;                  //no of rows
        int col=maze[0].length;              //no of columns
        ArrayList<String> res=new ArrayList<>();
        boolean[][] isVisited=new boolean[row][col];
        if(maze[0][0]==0 || maze[row-1][col-1]==0) return res;
        printPath(maze,0,0,row-1,col-1,"",isVisited,res);
        return res;
    }
    private void printPath(int[][] maze, int sr, int sc, int dr, int dc,
                           String s, boolean[][] isVisited, ArrayList<String> res){
        if(sr<0 || sc<0||sr>dr || sc>dc){
             return;
        }
        if(maze[sr][sc]==0) return;
        if(isVisited[sr][sc]==true){
            return;
        }
        if(sr==dr && sc==dc){
            res.add(s);
            return;
        }
        
        isVisited[sr][sc]=true;
        //down
        printPath(maze,sr+1,sc,dr,dc,s+'D',isVisited,res);
        //left
        printPath(maze,sr,sc-1,dr,dc,s+'L',isVisited,res);
        //right;
        printPath(maze,sr,sc+1,dr,dc,s+'R',isVisited,res);
        //up
        printPath(maze,sr-1,sc,dr,dc,s+'U',isVisited,res);
        
        isVisited[sr][sc]=false;
    }
}