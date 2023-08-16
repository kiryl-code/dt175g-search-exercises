package se.miun.dt175g.search.problems.eightpuzzle;

import se.miun.dt175g.search.util.Point;

/**
 * @author Peter Bergh
 */

public class Puzzle implements Cloneable {

	private Integer[][] puzzle;
	public Puzzle (Integer[] brickPlacement) {
		this.puzzle = new Integer[3][3];
		puzzle[0][0] = brickPlacement[0];
		puzzle[0][1] = brickPlacement[1];
		puzzle[0][2] = brickPlacement[2];
		puzzle[1][0] = brickPlacement[3];
		puzzle[1][1] = brickPlacement[4];
		puzzle[1][2] = brickPlacement[5];
		puzzle[2][0] = brickPlacement[6];
		puzzle[2][1] = brickPlacement[7];
		puzzle[2][2] = brickPlacement[8];

	}
	
	public void slide(Point p, Direction dir) {
		Point brick = new Point(p.x(), p.y());
		switch(dir) {
		case DOWN:
			brick.y(p.y()+1);
			break;
		case UP:
			brick.y(p.y()-1);
			break;
		case RIGHT:
			brick.x(p.x()+1);
			break;
		case LEFT:
			brick.x(p.x()-1);
			break;
		default:
			break;
		
		}
		Integer temp = puzzle[brick.y()][brick.x()];
		puzzle[brick.y()][brick.x()] = null;
		puzzle[p.y()][p.x()] = temp;
	}
	
	public Point getBlankSpace() {
		for(int i = 0; i<3; i++) {
			for(int j = 0; j < 3; j++) {
				if(puzzle[i][j] == null) {
					return new Point(j,i);
				}
			}
		}
		return null;
	}
	
	
	public Object clone() throws CloneNotSupportedException
    {
		Integer[] arr = new Integer[9];
		arr[0] = puzzle[0][0];
		arr[1] = puzzle[0][1];
		arr[2] = puzzle[0][2];
		arr[3] = puzzle[1][0];
		arr[4] = puzzle[1][1];
		arr[5] = puzzle[1][2];
		arr[6] = puzzle[2][0];
		arr[7] = puzzle[2][1];
		arr[8] = puzzle[2][2];
		
        return new Puzzle(arr);

    }
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i<3; i++) {
			for(int j = 0; j < 3; j++) {
				s +=puzzle[i][j] == null ? " " : puzzle[i][j];
			}
			s +="\n";
		}
		return s;
	}
	
	@Override
	public boolean equals(Object o) {
		Puzzle p = (Puzzle) o;
		for(int i = 0; i<3; i++) {
			for(int j = 0; j < 3; j++) {
				if(this.puzzle[i][j] != p.puzzle[i][j]) {
					return false;
				}
			}
		
		}
		return true;
	}
	
	public Integer getIntegerAt(Point p) {
		return puzzle[p.y()][p.x()];
	}
	
	public Point getPositionOf(Integer n) {
		for(int i = 0; i<3; i++) {
			for(int j = 0; j < 3; j++) {
				if(this.puzzle[i][j] == n) {
					return new Point(j,i);
				}
			}
		}
		return null;
	}

	
	@Override
    public int hashCode() {
		int hash = 7;
	    hash = 5 * hash + (puzzle[0][0] == null ? 0 : puzzle[0][0]);
	    hash = 7 * hash + (puzzle[0][1] == null ? 0 : puzzle[0][1]);
	    hash = 11 * hash + (puzzle[0][2] == null ? 0 : puzzle[0][2]);
	    hash = 13 * hash + (puzzle[1][0] == null ? 0 : puzzle[1][0]);
	    hash = 17 * hash + (puzzle[1][1] == null ? 0 : puzzle[1][1]);
	    hash = 19 * hash + (puzzle[1][2] == null ? 0 : puzzle[1][2]);
	    hash = 23 * hash + (puzzle[2][0] == null ? 0 : puzzle[2][0]);
	    hash = 29 * hash + (puzzle[2][1] == null ? 0 : puzzle[2][1]);
	    hash = 31 * hash + (puzzle[2][2] == null ? 0 : puzzle[2][2]);
	    return hash;
    }
	
}
