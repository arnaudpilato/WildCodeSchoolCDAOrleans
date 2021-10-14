package wcscda.small_game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class MouseController extends MouseAdapter {
    private static ArrayList<Integer> positionX = new ArrayList<>();
    private static ArrayList<Integer> positionY = new ArrayList<>();
    private final int[][] grid = {
            { 0, 0, 0 },
            { 0, 0, 0 },
            { 0, 0, 0 }
    };

    private final Board board;

    public static ArrayList<Integer> getPositionX() {
        return positionX;
    }

    public static void setPositionX(ArrayList<Integer> positionX) {
        MouseController.positionX = positionX;
    }

    public static ArrayList<Integer> getPositionY() {
        return positionY;
    }

    public static void setPositionY(ArrayList<Integer> positionY) {
        MouseController.positionY = positionY;
    }


    public MouseController(Board board) {
        this.board = board;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        board.redraw(new Drawable(){
            @Override
            public void draw(Graphics2D g, ImageObserver io) {

                boolean player1 = true;

                /*if (mouseEvent.getX() < 530) {
                    if (mouseEvent.getY() < 330 && grid[0][0] == 0) {
                        positionX.add(460);
                        positionY.add(260);
                        if (player1) {
                            grid[0][0] = 1;
                        } else {
                            grid[0][0] = 2;
                        }
                    }

                    if (mouseEvent.getY() >= 330 && mouseEvent.getY() <= 470 && grid[1][0] == 0) {
                        positionX.add(460);
                        positionY.add(400);
                        if (player1) {
                            grid[1][0] = 1;
                        } else {
                            grid[1][0] = 2;
                        }
                    }

                    if (mouseEvent.getY() > 470 && grid[2][0] == 0) {
                        positionX.add(460);
                        positionY.add(540);
                        if (player1) {
                            grid[2][0] = 1;
                        } else {
                            grid[2][0] = 2;
                        }
                    }
                }

                if ((mouseEvent.getX() >= 530) && mouseEvent.getX() <= 670) {
                    if (mouseEvent.getY() < 330 && grid[0][1] == 0) {
                        positionX.add(600);
                        positionY.add(260);
                        if (player1) {
                            grid[0][1] = 1;
                        } else {
                            grid[0][1] = 2;
                        }
                    }

                    if (mouseEvent.getY() >= 330 && mouseEvent.getY() <= 470 && grid[1][1] == 0) {
                        positionX.add(600);
                        positionY.add(400);
                        if (player1) {
                            grid[1][1] = 1;
                        } else {
                            grid[1][1] = 2;
                        }
                    }

                    if (mouseEvent.getY() > 470 && grid[2][1] == 0) {
                        positionX.add(600);
                        positionY.add(540);
                        if (player1) {
                            grid[2][1] = 1;
                        } else {
                            grid[2][1] = 2;
                        }
                    }
                }

                if (mouseEvent.getX() >= 670) {
                    if (mouseEvent.getY() < 330 && grid[0][2] == 0) {
                        positionX.add(740);
                        positionY.add(260);
                        if (player1) {
                            grid[0][2] = 1;
                        } else {
                            grid[0][2] = 2;
                        }
                    }

                    if (mouseEvent.getY() >= 330 && mouseEvent.getY() <= 470 && grid[1][2] == 0) {
                        positionX.add(740);
                        positionY.add(400);
                        if (player1) {
                            grid[1][2] = 1;
                        } else {
                            grid[1][2] = 2;
                        }
                    }

                    if (mouseEvent.getY() > 470 && grid[2][2] == 0) {
                        positionX.add(740);
                        positionY.add(540);
                        if (player1) {
                            grid[2][2] = 1;
                        } else {
                            grid[2][2] = 2;
                        }
                    }
                } */

                if (mouseEvent.getX() < 530) {
                    if (mouseEvent.getY() < 330 && grid[0][0] == 0) {
                        positionX.add(460);
                        positionY.add(260);
                        if (player1) {
                            grid[0][0] = 1;
                        } else {
                            grid[0][0] = 2;
                        }
                    }

                    if (mouseEvent.getY() >= 330 && mouseEvent.getY() <= 470 && grid[1][0] == 0) {
                        positionX.add(460);
                        positionY.add(400);
                        if (player1) {
                            grid[1][0] = 1;
                        } else {
                            grid[1][0] = 2;
                        }
                    }

                    if (mouseEvent.getY() > 470 && grid[2][0] == 0) {
                        positionX.add(460);
                        positionY.add(540);
                        if (player1) {
                            grid[2][0] = 1;
                        } else {
                            grid[2][0] = 2;
                        }
                    }
                }

                if ((mouseEvent.getX() >= 530) && mouseEvent.getX() <= 670) {
                    if (mouseEvent.getY() < 330 && grid[0][1] == 0) {
                        positionX.add(600);
                        positionY.add(260);
                        if (player1) {
                            grid[0][1] = 1;
                        } else {
                            grid[0][1] = 2;
                        }
                    }

                    if (mouseEvent.getY() >= 330 && mouseEvent.getY() <= 470 && grid[1][1] == 0) {
                        positionX.add(600);
                        positionY.add(400);
                        if (player1) {
                            grid[1][1] = 1;
                        } else {
                            grid[1][1] = 2;
                        }
                    }

                    if (mouseEvent.getY() > 470 && grid[2][1] == 0) {
                        positionX.add(600);
                        positionY.add(540);
                        if (player1) {
                            grid[2][1] = 1;
                        } else {
                            grid[2][1] = 2;
                        }
                    }
                }

                if (mouseEvent.getX() >= 670) {
                    if (mouseEvent.getY() < 330 && grid[0][2] == 0) {
                        positionX.add(740);
                        positionY.add(260);
                        if (player1) {
                            grid[0][2] = 1;
                        } else {
                            grid[0][2] = 2;
                        }
                    }

                    if (mouseEvent.getY() >= 330 && mouseEvent.getY() <= 470 && grid[1][2] == 0) {
                        positionX.add(740);
                        positionY.add(400);
                        if (player1) {
                            grid[1][2] = 1;
                        } else {
                            grid[1][2] = 2;
                        }
                    }

                    if (mouseEvent.getY() > 470 && grid[2][2] == 0) {
                        positionX.add(740);
                        positionY.add(540);
                        if (player1) {
                            grid[2][2] = 1;
                        } else {
                            grid[2][2] = 2;
                        }
                    }
                }

                g.setColor(Color.green);
                for (int i = 0; i < MouseController.getPositionX().size(); i++) {
                    if (player1 == true) {
                        g.drawLine(positionX.get(i) - 30, positionY.get(i) - 30, positionX.get(i) + 30, positionY.get(i) +30);
                        g.drawLine(positionX.get(i) + 30, positionY.get(i) - 30, positionX.get(i) - 30, positionY.get(i) +30);

                        player1 = false;
                    } else {
                        g.drawOval(positionX.get(i) - 30, positionY.get(i) - 30, 60, 60);

                        player1 = true;
                    }
                }

                if (grid[0][0] == 1 && grid[0][1] == 1 && grid[0][2] == 1 ||
                        grid[1][0] == 1 && grid[1][1] == 1 && grid[1][2] == 1 ||
                        grid[2][0] == 1 && grid[2][1] == 1 && grid[2][2] == 1 ||

                        grid[0][0] == 1 && grid[1][0] == 1 && grid[2][0] == 1 ||
                        grid[0][1] == 1 && grid[1][1] == 1 && grid[2][1] == 1 ||
                        grid[0][2] == 1 && grid[1][2] == 1 && grid[2][2] == 1 ||

                        grid[0][0] == 1 && grid[1][1] == 1 && grid[2][2] == 1 ||
                        grid[2][0] == 1 && grid[1][1] == 1 && grid[0][2] == 1) {
                    System.out.println("Player 1 Win");
                }

                if (grid[0][0] == 2 && grid[0][1] == 2 && grid[0][2] == 2 ||
                        grid[1][0] == 2 && grid[1][1] == 2 && grid[1][2] == 2 ||
                        grid[2][0] == 2 && grid[2][1] == 2 && grid[2][2] == 2 ||

                        grid[0][0] == 2 && grid[1][0] == 2 && grid[2][0] == 2 ||
                        grid[0][1] == 2 && grid[1][1] == 2 && grid[2][1] == 2 ||
                        grid[0][2] == 2 && grid[1][2] == 2 && grid[2][2] == 2 ||

                        grid[0][0] == 2 && grid[1][1] == 2 && grid[2][2] == 2 ||
                        grid[2][0] == 2 && grid[1][1] == 2 && grid[0][2] == 2) {
                    System.out.println("Player 2 Win");
                }
            }
        } );
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }
}
