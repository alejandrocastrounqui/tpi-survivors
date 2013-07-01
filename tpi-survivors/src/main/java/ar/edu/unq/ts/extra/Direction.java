package ar.edu.unq.ts.extra;

public enum Direction {
	
	//public static final double xmove = 10;

	
	//desde el norte en sentido horario		
    ESTE(0, "Este", 1 , 0), //
    NORESTE(1, "Nor-este", 0.707 , -0.707), //
    NORTE(2, "Norte", 0 , -1), //
    NOROESTE(3, "Nor-oeste", -0.707 , -0.707), //
    OESTE(4, "Oeste", -1 , 0), //
    SUROESTE(5, "Sur-oeste", -0.707 , 0.707), //
    SUR(6, "Sur", 0 , 1), //
    SURESTE(7, "Sur-este", 0.707 , 0.707); //

    
    /*
     * 1^2 = x^2 * 2
     * 1/2 = x^2
     * x = (1/2)^(1/2)
     * 
     */
    
    private int index;
    
    private double xMove;

    private double yMove;
    
    private String name;

    private Direction(final int index, final String name, final double xMove, final double yMove){
        this.xMove = xMove;
        this.yMove = yMove;
        this.index = index;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getIndex() {
        return this.index;
    }
    
    public double getXMove() {
		return xMove;
	}
    
    public double getYMove() {
		return yMove;
	}
    
    
	
}
