package magicsquares;

public class Square {

    /*
        Instance variables for the size of the
        square and the current position within it.
    */
    private int[][] square;
    private int n;
    private int row;
    private int col;
    private final int MAGIC_CONSTANT;
    public Square(int n) throws IllegalArgumentException {
        // A check to make sure we are only dealing with odd magic squares.
        if(n%2==0) throw new IllegalArgumentException("Even magic squares are not supported, set n to an odd number.");
        square = new int[n][n];
        this.n = n;
        row = 0;
        // Sets column to the center of the square.
        col = (n-1)/2;
        MAGIC_CONSTANT = n*((n*n+1)/2);
        solve();
    }

    private void solve(){
        int x = 1;
        square[row][col] = x;
        // Loop to move the marker up and to the right placing the appropriate numbers in each array.
        for (int i =0; i<(n*n)-1; i++){
            x++;
            row--;
            col++;
            check();
            square[row][col]=x;
        }
    }

    private void check(){
        if(row <0) row = n-1;
        if(row >n-1) row =row-n;
        if(col > n-1) col = col-n;
        if(col < 0) col = n-1;
        if(square[row][col] > 0){
            row+=2;
            col--;
            check();
        }
    }


    public boolean isSumRowN(int r){
        if(r >= n || r < 0 ) throw new IllegalArgumentException("Number between 0 and n expected.");
        int sum = 0;
        for (int i = 0; i< square[r].length; i++) sum += square[r][i];
        return sum == MAGIC_CONSTANT;
    }

    public boolean isSumColN(int c){
        if(c >= n || c < 0 ) throw new IllegalArgumentException("Number between 0 and n expected.");
        int sum = 0;
        for (int[] colValue : square) sum += colValue[c];

        return sum == MAGIC_CONSTANT;
    }

    public boolean isSumDiagonalN(int d){
        if(d > 1 || d < 0 ) throw new IllegalArgumentException("Number between 0 and 1 expected.");
        int[] sum = new int[2];
        for (int i = 0; i < square.length; i++) {
            sum[0] += square[i][i];
        }
        for (int j = square.length-1; j >= 0; j--) {
            sum[1] += square[j][j];
        }
        return sum[d] == MAGIC_CONSTANT;
    }

    @Override
    public String toString() {
        // Simple toString to print out the contents of the square.
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                stringBuilder.append("[").append(square[i][j]).append("] ");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n\nMagic square Size: ").append(n).append("\nMagic Constant: ").append(MAGIC_CONSTANT);
        return stringBuilder.toString();
    }
}
