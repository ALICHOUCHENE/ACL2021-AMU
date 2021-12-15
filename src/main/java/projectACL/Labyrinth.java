package projectACL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//class Labyrinth: a maze with 2 dimensions dimx an dimy
public class Labyrinth {
		
		private final static int dimx=12;
		private final static int dimy=12;

		
		private static Tile[][] build= new Tile[dimx][dimy];
				
		private int [] heroSpawn;
		private ArrayList<int[]> monsterSpawn=new ArrayList<int[]>();
		
	
		// Constructor

		public  Labyrinth(int level) {			
			BufferedReader LabReader;
			// add case level :each level has a different design 
			try {
				String source = "src/main/java/levels/level_"+level+".txt";
				LabReader = new BufferedReader(new FileReader(source));
				this.setCases(LabReader);
				LabReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				try {
					String source = "main/java/levels/level_"+level+".txt";
					LabReader = new BufferedReader(new FileReader(source));
					this.setCases(LabReader);
					LabReader.close();
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		}

		// this function checks if the hero's movement (x,y) is valid in the labyrinth or not
		public static boolean validatePos(int xPos, int yPos) {
			return (( 0 <= xPos ) && (xPos < Labyrinth.dimx)  && (0 <= yPos) && (yPos < Labyrinth.dimy)&&(build[yPos][xPos].isCanWalkOn()));
		}
		
		private void setCases(BufferedReader LabReader) throws IOException { 
			

			String line;
			String tiles[];
			int code;
			try {
				for(int i=0;i<this.dimy;i++) {
					
					line = LabReader.readLine();
					tiles = line.split(",");
					
					for(int j=0;j<this.dimx;j++) {
						
						code=Integer.parseInt(tiles[j]);
						switch(code) {
						
						case 0:
							build[i][j]=new Wall(); 
							break;
						
						case 1:
							build[i][j]=new Floor();
							break;
						
						case 2:
							build[i][j]=new Door();
							break;
							
						case 3:
							build[i][j]=new Floor();
							this.heroSpawn= new int []{j,i};
							break;
						
						case 4:
							build[i][j]=new Floor();
							this.monsterSpawn.add(new int[] {j,i});
							break;
							
						default:
							break;
						}			
					}
				}
					
			}catch(IOException e) {
				System.out.println("Fichier source inexistant");
			}
		}
		
		
		//getters
		public static int getDimX() {
			return Labyrinth.dimx;
		}
		
		public static int getDimY() {
			return Labyrinth.dimy;
		}
		public static Tile[][] getBuild() {
			return build;
		}

		public int[] getHeroSpawn() {
			return heroSpawn;
		}

		public ArrayList<int[]> getMonsterSpawn() {
			return monsterSpawn;
		}
		
	
}
