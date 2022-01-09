package projectACL;


import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import engine.Game;

//class Labyrinth: a maze with 2 dimensions dimx an dimy
public class Labyrinth {
		
		private static int dimx=12;
		private static int dimy=12;

		private static Tile[][] build;
				
		private int [] heroSpawn;
		private int [] finishLine;
		private static ArrayList<int[]> wormholes = new ArrayList<int[]>();
		
		private ArrayList<int[]> monsterSpawn=new ArrayList<int[]>();
		private ArrayList<int[]> monster2Spawn=new ArrayList<int[]>();
		private ArrayList<int[]> LifeSpawn=new ArrayList<int[]>();
		// Constructor

		public  Labyrinth(int level) {			
			BufferedReader LabReader;
			try {
				String source = "src/main/java/levels/level_"+level+".txt";
				LabReader = new BufferedReader(new FileReader(source));
				this.setLabyrinthSize(LabReader);
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
			return (( 0 <= xPos ) && (xPos < Labyrinth.dimx)  && (0 <= yPos) && (yPos < Labyrinth.dimy)&& ( build[yPos][xPos].isCanWalkOn()));
		}
		

		public static int[] teleporte (int xPos, int yPos){
			if (build[yPos][xPos].isTeleporte()) {
				if (wormholes.isEmpty()) {
					return null;
				}else if (wormholes.size()==1) {
					return null;
				}
				else {
					Random rand = new Random();
					int random_index;
					do {
						random_index= rand.nextInt(wormholes.size());
					}while((wormholes.get(random_index)[0]==xPos) && (wormholes.get(random_index)[1]==yPos));
					int newxPos = wormholes.get(random_index)[0];
					int newyPos = wormholes.get(random_index)[1];
					return(new int[] {newxPos,newyPos});
				}
			}else 
				return null;
		}
		
		private void setLabyrinthSize(BufferedReader LabReader) throws IOException {
			String line;
			String lastLine = null;
			String tiles[];
			Labyrinth.dimx=0;
			Labyrinth.dimy=0;
			try {
				while ( (line = LabReader.readLine()) != null) {
					lastLine = line;
					Labyrinth.dimy++;
				}
				tiles = lastLine.split(",");
				Labyrinth.dimx=tiles.length;

			}
			catch(IOException e) {
				System.out.println("Fichier source inexistant");
			}
		}
		
		private void setCases(BufferedReader LabReader) throws IOException { 
			

			String line;
			String tiles[];
			this.build= new Tile[dimy][dimx];
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
							this.finishLine= new int [] {j,i};
							break;
							
						case 3:
							build[i][j]=new Floor();
							this.heroSpawn= new int []{j,i};
							break;
						 
						case 4:
							build[i][j]=new Floor();
							this.monsterSpawn.add(new int[] {j,i,1});
							break;
						case 5:
							build[i][j]=new Floor();
							this.monsterSpawn.add(new int[] {j,i,2});
							break;
						case 6:
							build[i][j]=new Wormhole();
							this.wormholes.add(new int [] {j,i});
							break;
							
						case 7:
							
							build[i][j]=new Life();
							this.LifeSpawn.add(new int[] {j,i});
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
		

		//getters and setters

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
		
		public ArrayList<int[]> getLifeSpawn() {
			return LifeSpawn;
		}
		public ArrayList<int[]> getMonster2Spawn() {
			return monster2Spawn;
		}

		public int[] getFinishLine() {
			return finishLine;
		}

		public void setFinishLine(int[] finishLine) {
			this.finishLine = finishLine;
		}

		public ArrayList<int[]> getWormholes() {
			return wormholes;
		}

		public void setWormholes(ArrayList<int[]> wormholes) {
			this.wormholes = wormholes;
		}
		

		/*public boolean levelisFinished(int level) {
		
			return (Labyrinth.getDimX()-1==hero.getxPos()) & (Labyrinth.getDimY()-2==hero.getyPos());   // this is not working, getxpos is null
			
		}*/
	
}