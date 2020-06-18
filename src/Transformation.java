
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.*;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author shovon
 */
public class Transformation implements GLEventListener, KeyListener {
    /**
     * Interface to the GLU library.
     */
    private GLU glu;
    
    double c1 [] = {40,80,1};
    double c2 [] = {100,80,1};
    double c3 [] = {100,40,1};
    double c4 [] =  {40,40,1};
    
    boolean right = false;
    boolean left = false;
    boolean up = false;
    boolean down = false;
    boolean ne = false;
    boolean nw = false;
    boolean se = false;
    boolean sw = false;
    boolean bigger = false;
    boolean smaller = false;
    boolean shorter = false;
    boolean taller = false;
    boolean fatter = false;
    boolean slimmer = false;
    boolean left_rotate = false;
    boolean right_rotate = false;
    boolean shear_x = false;
    boolean shear_y = false;
    boolean shear_all = false;;

    /**
     * Take care of initialization here.
     * @param gld
     */
    @Override
    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL().getGL2();
        glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
    }

    /**
     * Take care of drawing here.
     * @param drawable
     */
    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        
        if (right) {
        	right(gl);
        }
        else if(left) {
        	left(gl);
        }
        else if(up) {
        	up(gl);
        }
        else if(down) {
        	down(gl);
        }
        else if(ne) {
        	ne(gl);
        }
        else if(nw) {
        	nw(gl);
        }
        else if(se) {
        	se(gl);
        }
        else if(sw) {
        	sw(gl);
        }
        else if(bigger) {
        	bigger(gl);
        }
        else if(smaller) {
        	smaller(gl);
        }
        else if(shorter) {
        	shorter(gl);
        }
        else if(taller) {
        	taller(gl);
        }
        else if(fatter) {
        	fatter(gl);
        }
        else if(slimmer) {
        	slimmer(gl);
        }
        else if(left_rotate) {
        	left_rotate(gl);
        }
        else if(right_rotate) {
        	right_rotate(gl);
        }
        else if(shear_x) {
        	shear_x(gl);
        }
        else if(shear_y) {
        	shear_y(gl);
        }
        else if(shear_all) {
        	shear_all(gl);
        }
        else{
            first(gl);
        }
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //do nothing
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        //do nothing
    }
    
    public void keyPressed(KeyEvent ke) {
        
    	
    	if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
    		right = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
    		left = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_UP) {
    		up = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
    		down = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_1) {
    		ne = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_2) {
    		nw = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_3) {
    		se = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_4) {
    		sw = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_B) {
    		bigger = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_S) {
    		smaller = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_T) {
    		taller = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_P) {
    		shorter = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_M) {
    		fatter = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_C) {
    		slimmer = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_L) {
    		left_rotate = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_R) {
    		right_rotate = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_X) {
    		shear_x = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_Y) {
    		shear_y = true;
    	}
    	else if (ke.getKeyCode() == KeyEvent.VK_Z) {
    		shear_all = true;
    	}
    	
    }
    
    public void keyTyped(KeyEvent ke) {
    	//Not implementing anything
    }
    
    public void keyReleased(KeyEvent ke) {
    	//Not implementing anything
    }



    private void first(GL2 gl) {
       //write your own code

       
       gl.glPointSize(1.0f);
       gl.glColor3d(1, 0, 0);//red
       gl.glBegin(GL2.GL_LINE_LOOP);
       gl.glVertex2d(c1[0], c1[1]);
       gl.glVertex2d(c2[0], c2[1]);
       gl.glVertex2d(c3[0], c3[1]);
       gl.glVertex2d(c4[0], c4[1]);
       gl.glEnd();

     }
    
	 private void right(GL2 gl) {
		right = false;
		double trans [][] = {{1,0,5},{0,1,0},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
	  
	 }
	 
	 private void left(GL2 gl) {
		 left = false; 
		 double trans [][] = {{1,0,-5},{0,1,0},{0,0,1}};
		 double transC [][] = {c1,c2,c3,c4};
		 double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		 for(int i=0; i<trans.length;i++) {
			 for(int j=0;j<transC.length;j++) {
				 double sum = 0;
				 for(int k=0;k<trans[i].length;k++) {
					 sum+= trans[i][k]*transC[j][k];
				 }
				 transC1[j][i]=sum;
			 }
		 }
		 c1[0] = transC1[0][0];
		 c1[1] = transC1[0][1];
		 c2[0] = transC1[1][0];
		 c2[1] = transC1[1][1];
		 c3[0] = transC1[2][0];
		 c3[1] = transC1[2][1];
		 c4[0] = transC1[3][0];
		 c4[1] = transC1[3][1];
	  
	 }
	 
	 private void up(GL2 gl) {
		up = false;
		double trans [][] = {{1,0,0},{0,1,5},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
		  
	 }
	 private void down(GL2 gl) {
		down = false;
		double trans [][] = {{1,0,0},{0,1,-5},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
			  
	 }
	 private void ne(GL2 gl) {
		 ne = false;
		 double trans [][] = {{1,0,5},{0,1,5},{0,0,1}};
		 double transC [][] = {c1,c2,c3,c4};
		 double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		 for(int i=0; i<trans.length;i++) {
			 for(int j=0;j<transC.length;j++) {
				 double sum = 0;
				 for(int k=0;k<trans[i].length;k++) {
					 sum+= trans[i][k]*transC[j][k];
				 }
				 transC1[j][i]=sum;
			 }
		 }
		 c1[0] = transC1[0][0];
		 c1[1] = transC1[0][1];
		 c2[0] = transC1[1][0];
		 c2[1] = transC1[1][1];
		 c3[0] = transC1[2][0];
		 c3[1] = transC1[2][1];
		 c4[0] = transC1[3][0];
		 c4[1] = transC1[3][1];	
				  
	 }
	 private void nw(GL2 gl) {
		nw = false;
		double trans [][] = {{1,0,-5},{0,1,5},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
				  
	 }
	 private void se(GL2 gl) {
		se = false;
		double trans [][] = {{1,0,5},{0,1,-5},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
				  
	}
	 private void sw(GL2 gl) {
		sw = false;
		double trans [][] = {{1,0,-5},{0,1,-5},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
				  
	}
	 private void bigger(GL2 gl) {
		bigger = false;
		double tx4=c4[0];
		double ty4=c4[1];
		transformToFromOrigin(-tx4,-ty4);
		
		double trans [][] = {{1.05,0,0},{0,1.05,0},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
		transformToFromOrigin(tx4,ty4);		
					  
	}
	 private void smaller(GL2 gl) {
		smaller = false;
		double tx4=c4[0];
		double ty4=c4[1];
		transformToFromOrigin(-tx4,-ty4);
		double trans [][] = {{0.9523,0,0},{0,0.9523,0},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
		transformToFromOrigin(tx4,ty4);
	}
	 private void taller(GL2 gl) {
		taller = false;
		double tx4=c4[0];
		double ty4=c4[1];
		transformToFromOrigin(-tx4,-ty4);
		double trans [][] = {{1,0,0},{0,1.05,0},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
		transformToFromOrigin(tx4,ty4);
		
	}
	 private void shorter(GL2 gl) {
		shorter = false;
		double tx4=c4[0];
		double ty4=c4[1];
		transformToFromOrigin(-tx4,-ty4);
		double trans [][] = {{1,0,0},{0,0.9523,0},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
		transformToFromOrigin(tx4,ty4);
						  
	}
	 private void fatter(GL2 gl) {
		fatter = false;
		double tx4=c4[0];
		double ty4=c4[1];
		transformToFromOrigin(-tx4,-ty4);
		double trans [][] = {{1.05,0,0},{0,1,0},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
		transformToFromOrigin(tx4,ty4);
					  
	}
	 private void slimmer(GL2 gl) {
		slimmer = false;
		double tx4=c4[0];
		double ty4=c4[1];
		transformToFromOrigin(-tx4,-ty4);
		double trans [][] = {{0.9523,0,0},{0,1,0},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
		

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
		transformToFromOrigin(tx4,ty4);
					  
	}
	 private void left_rotate(GL2 gl) {				
		left_rotate = false;
		
		double tx4=c4[0];
		double ty4=c4[1];
		transformToFromOrigin(-tx4,-ty4);
		
		double cosx = 1/Math.sqrt(2);
		double sinx = 1/Math.sqrt(2);
		
		double trans [][] = {{cosx,-sinx,0},{sinx,cosx,0},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum = sum+trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
		transformToFromOrigin(tx4,ty4);
		

	 }
	 private void right_rotate(GL2 gl) {
		right_rotate = false;
		double tx4=c4[0];
		double ty4=c4[1];
		transformToFromOrigin(-tx4,-ty4);
		
		double cosx = 1/Math.sqrt(2);
		double sinx = -1/Math.sqrt(2);
		
		double trans [][] = {{cosx,-sinx,0},{sinx,cosx,0},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum = sum+trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
				//System.out.println(sum);
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
		transformToFromOrigin(tx4,ty4);
					  
	 }
	 private void shear_x(GL2 gl) {
		shear_x = false;	
		double tx4=c4[0];
		double ty4=c4[1];
		transformToFromOrigin(-tx4,-ty4);
		
		double trans [][] = {{1,0.10,0},{0,1,0},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
		transformToFromOrigin(tx4,ty4);
					  
	 }
	 private void shear_y(GL2 gl) {
		shear_y = false;
		double tx4=c4[0];
		double ty4=c4[1];
		transformToFromOrigin(-tx4,-ty4);
		
		double trans [][] = {{1,0,0},{.10,1,0},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
		transformToFromOrigin(tx4,ty4);
					  
	 }
	 private void shear_all(GL2 gl) {
		shear_all = false;
		double tx4=c4[0];
		double ty4=c4[1];
		transformToFromOrigin(-tx4,-ty4);
		double trans [][] = {{1,0.10,0},{0.10,1,0},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};
		double transC1 [][] = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC1[j][i]=sum;
			}
		}
		c1[0] = transC1[0][0];
		c1[1] = transC1[0][1];
		c2[0] = transC1[1][0];
		c2[1] = transC1[1][1];
		c3[0] = transC1[2][0];
		c3[1] = transC1[2][1];
		c4[0] = transC1[3][0];
		c4[1] = transC1[3][1];
		transformToFromOrigin(tx4,ty4);
					  
	}
	 
	public void transformToFromOrigin(double tx4,double ty4) {
		double trans [][] = {{1,0,tx4},{0,1,ty4},{0,0,1}};
		double transC [][] = {c1,c2,c3,c4};

		for(int i=0; i<trans.length;i++) {
			for(int j=0;j<transC.length;j++) {
				double sum = 0;
				for(int k=0;k<trans[i].length;k++) {
					sum+= trans[i][k]*transC[j][k];
				}
				transC[j][i]=sum;
			}
		}
		c1[0] = transC[0][0];
		c1[1] = transC[0][1];
		c2[0] = transC[1][0];
		c2[1] = transC[1][1];
		c3[0] = transC[2][0];
		c3[1] = transC[2][1];
		c4[0] = transC[3][0];
		c4[1] = transC[3][1];
	}
	 
    
    
    public void dispose(GLAutoDrawable arg0) {
        //do nothing
    }
}