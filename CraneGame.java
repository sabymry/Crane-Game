package com.example.dev1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Random rand = new Random();
        final int[] power = {rand.nextInt(25)};
        System.out.println(power[0]);
        int p1Weight = 2;
        int p2Weight = 3;
        final boolean[] p1c = {false};
        final boolean[] p2c = {false};
        final boolean[] failedCatch = {false};
        final boolean[] isCarried = {false};
        final boolean[] p1b1 = {false};
        final boolean[] p2b1 = {false};
        final boolean[] canSlide = {true};
        final double[] p1Xpos = new double[1];
        final double[] p1Ypos = new double[1];
        final double[] p2Xpos = new double[1];
        final double[] p2Ypos = new double[1];

        final int[] op = {0};

        final int[] craneXPos = {300};

        final double[] lineY={275};

        final double[] cmx1V={320};
        final double[] cmyV={275};

        final double cmx1=cmx1V[0];
        final double cmy=cmyV[0];

        final double[] cL1x1V={300};
        final double[] cL1x2V={290};
        final double[] cL1y1V={275};
        final double[] cL1y2V={295};

        final double cL1x1 = cL1x1V[0];
        final double cL1x2 = cL1x2V[0];
        final double cL1y1 = cL1y1V[0];
        final double cL1y2 = cL1y2V[0];

        final double[] cL2x1V={290};
        final double[] cL2x2V={300};
        final double[] cL2y1V={295};
        final double[] cL2y2V={315};

        final double cL2x1 = cL2x1V[0];
        final double cL2x2 = cL2x2V[0];
        final double cL2y1 = cL2y1V[0];
        final double cL2y2 = cL2y2V[0];

        final double[] cR1x1V={340};
        final double[] cR1x2V={350};
        final double[] cR1y1V={275};
        final double[] cR1y2V={295};

        final double cR1x1 = cR1x1V[0];
        final double cR1x2 = cR1x2V[0];
        final double cR1y1 = cR1y1V[0];
        final double cR1y2 = cR1y2V[0];

        final double[] cR2x1V={350};
        final double[] cR2x2V={340};
        final double[] cR2y1V={295};
        final double[] cR2y2V={315};

        final double cR2x1 = cR2x1V[0];
        final double cR2x2 = cR2x2V[0];
        final double cR2y1 = cR2y1V[0];
        final double cR2y2 = cR2y2V[0];

        int screenSizeX = 1024;
        int screenSizeY = 576;
        Group root = new Group();
        Scene scene = new Scene(root, screenSizeX, screenSizeY, Color.LIGHTSKYBLUE);

        Image icon = new Image("file:icon.png");
        stage.setTitle("Crane Game");
        stage.getIcons().add(icon);
        stage.setResizable(false);

        Text titleText = new Text();
        titleText.setText("Crane Game");
        titleText.setX(360);
        titleText.setY(150);
        titleText.setFont(Font.font("Verdana",50));
        titleText.setFill(Color.WHITE);

        Text fullscreenText = new Text();
        fullscreenText.setText("FullScreen:");
        fullscreenText.setX(250);
        fullscreenText.setY(250);
        fullscreenText.setFont(Font.font("Verdana",50));
        fullscreenText.setFill(Color.WHITE);

        Text fOn = new Text();
        fOn.setText("On");
        fOn.setX(550);
        fOn.setY(250);
        fOn.setFont(Font.font("Verdana",60));
        fOn.setFill(Color.WHITE);

        Text fOff = new Text();
        fOff.setText("Off");
        fOff.setX(650);
        fOff.setY(250);
        fOff.setFont(Font.font("Verdana",60));
        fOff.setFill(Color.WHITE);

        Text startButtonText = new Text();
        startButtonText.setText("Start");
        startButtonText.setX(480);
        startButtonText.setY(250);
        startButtonText.setFont(Font.font("Verdana",30));
        startButtonText.setFill(Color.WHITE);

        Text optionsButtonText = new Text();
        optionsButtonText.setText("Options");
        optionsButtonText.setX(465);
        optionsButtonText.setY(350);
        optionsButtonText.setFont(Font.font("Verdana",30));
        optionsButtonText.setFill(Color.WHITE);

        Text quitButtonText = new Text();
        quitButtonText.setText("Quit");
        quitButtonText.setX(490);
        quitButtonText.setY(450);
        quitButtonText.setFont(Font.font("Verdana",30));
        quitButtonText.setFill(Color.WHITE);

        Text optionsMenuTitleText = new Text();
        optionsMenuTitleText.setText("Options");
        optionsMenuTitleText.setX(420);
        optionsMenuTitleText.setY(100);
        optionsMenuTitleText.setFont(Font.font("Verdana",50));
        optionsMenuTitleText.setFill(Color.WHITE);

        Rectangle optionsBackButton = new Rectangle();
        optionsBackButton.setX(250);
        optionsBackButton.setY(400);
        optionsBackButton.setWidth(200);
        optionsBackButton.setHeight(100);
        optionsBackButton.setFill(Color.LIGHTSKYBLUE);
        optionsBackButton.setStrokeWidth(5);
        optionsBackButton.setStroke(Color.WHITE);

        Text optionsBackButtonText = new Text();
        optionsBackButtonText.setFill(Color.WHITE);
        optionsBackButtonText.setFont(Font.font("Verdana",30));
        optionsBackButtonText.setX(275);
        optionsBackButtonText.setY(450);
        optionsBackButtonText.setText("Back");

        Rectangle optionsApplyButton = new Rectangle();
        optionsApplyButton.setX(475);
        optionsApplyButton.setY(400);
        optionsApplyButton.setWidth(200);
        optionsApplyButton.setHeight(100);
        optionsApplyButton.setFill(Color.LIGHTSKYBLUE);
        optionsApplyButton.setStrokeWidth(5);
        optionsApplyButton.setStroke(Color.WHITE);

        Text optionsApplyButtonText = new Text();
        optionsApplyButtonText.setText("Apply");
        optionsApplyButtonText.setFill(Color.WHITE);
        optionsApplyButtonText.setFont(Font.font("Verdana",30));
        optionsApplyButtonText.setX(500);
        optionsApplyButtonText.setY(450);

        Rectangle startButton = new Rectangle();
        startButton.setX(355);
        startButton.setY(200);
        startButton.setWidth(330);
        startButton.setHeight(75);
        startButton.setFill(Color.LIGHTSKYBLUE);
        startButton.setStrokeWidth(5);
        startButton.setStroke(Color.WHITE);

        Rectangle optionsButton = new Rectangle();
        optionsButton.setX(355);
        optionsButton.setY(300);
        optionsButton.setWidth(330);
        optionsButton.setHeight(75);
        optionsButton.setFill(Color.LIGHTSKYBLUE);
        optionsButton.setStrokeWidth(5);
        optionsButton.setStroke(Color.WHITE);

        Rectangle quitButton = new Rectangle();
        quitButton.setX(355);
        quitButton.setY(400);
        quitButton.setWidth(330);
        quitButton.setHeight(75);
        quitButton.setFill(Color.LIGHTSKYBLUE);
        quitButton.setStrokeWidth(5);
        quitButton.setStroke(Color.WHITE);










        Rectangle craneLowArm = new Rectangle();
        craneLowArm.setX(150);
        craneLowArm.setY(100);
        craneLowArm.setWidth(50);
        craneLowArm.setHeight(700);
        craneLowArm.setFill(Color.WHITE);

        Rectangle craneHighArm = new Rectangle();
        craneHighArm.setX(150);
        craneHighArm.setY(100);
        craneHighArm.setHeight(50);
        craneHighArm.setWidth(800);
        craneHighArm.setFill(Color.WHITE);

        Line b1L = new Line();
        b1L.setStartX(240);
        b1L.setStartY(570);
        b1L.setEndX(240);
        b1L.setEndY(400);
        b1L.setStrokeWidth(4);

        Line b1D = new Line();
        b1D.setStartX(240);
        b1D.setStartY(570);
        b1D.setEndX(650);
        b1D.setEndY(570);
        b1D.setStrokeWidth(4);

        Line b1R = new Line();
        b1R.setStartX(650);
        b1R.setStartY(570);
        b1R.setEndX(650);
        b1R.setEndY(400);
        b1R.setStrokeWidth(4);

        Line b2L = new Line();
        b2L.setStartX(675);
        b2L.setStartY(570);
        b2L.setEndX(675);
        b2L.setEndY(400);
        b2L.setStrokeWidth(4);

        Line b2D = new Line();
        b2D.setStartX(675);
        b2D.setStartY(570);
        b2D.setEndX(950);
        b2D.setEndY(570);
        b2D.setStrokeWidth(4);

        Line b2R = new Line();
        b2R.setStartX(950);
        b2R.setEndX(950);
        b2R.setStartY(570);
        b2R.setEndY(400);
        b2R.setStrokeWidth(4);




        Line cLine = new Line();
        cLine.setStartX(cL1x1);
        cLine.setEndX(cR1x1);
        cLine.setStartY(cL1y1);
        cLine.setEndY(cR1y1);
        cLine.setStrokeWidth(3);

        Rectangle Crane = new Rectangle();
        Crane.setX(craneXPos[0]);
        Crane.setY(100);
        Crane.setWidth(40);
        Crane.setHeight(175);
        Crane.setFill(Color.WHITE);

        Line cL1 = new Line();
        cL1.setStrokeWidth(3);
        cL1.setStartX(cL1x1);
        cL1.setEndX(cL1x2);
        cL1.setStartY(cL1y1);
        cL1.setEndY(cL1y2);

        Line cL2 = new Line();
        cL2.setStrokeWidth(3);
        cL2.setStartX(cL2x1);
        cL2.setEndX(cL2x2);
        cL2.setStartY(cL2y1);
        cL2.setEndY(cL2y2);

        Line cR1 = new Line();
        cR1.setStrokeWidth(3);
        cR1.setStartX(cR1x1);
        cR1.setEndX(cR1x2);
        cR1.setStartY(cR1y1);
        cR1.setEndY(cR1y2);

        Line cR2 = new Line();
        cR2.setStrokeWidth(3);
        cR2.setStartX(cR2x1);
        cR2.setEndX(cR2x2);
        cR2.setStartY(cR2y1);
        cR2.setEndY(cR2y2);

        Line cMLine = new Line();
        cMLine.setStrokeWidth(4);
        cMLine.setStartX(320);
        cMLine.setStartY(275);
        cMLine.setEndX(320);
        cMLine.setEndY(275);

        Rectangle p1 = new Rectangle();
        p1.setFill(Color.RED);
        p1.setWidth(40);
        p1.setHeight(40);
        p1.setStroke(Color.BLACK);
        p1.setX(350);
        p1.setY(525);

        Rectangle p2 = new Rectangle();
        p2.setFill(Color.YELLOW);
        p2.setWidth(40);
        p2.setHeight(40);
        p2.setStroke(Color.BLACK);
        p2.setX(475);
        p2.setY(525);





        EventHandler<MouseEvent> mouseEventQuit = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if(e.getSceneX()>=355 && e.getSceneX()<=685 && e.getSceneY()>=400 && e.getSceneY()<=475)
                {
                    Platform.exit();
                }
            }
        };

        EventHandler<MouseEvent> mouseEventBackButtonOptions = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if(e.getSceneX()>=250 && e.getSceneX()<=450 && e.getSceneY()>=400 && e.getSceneY()<=500)
                {
                    op[0] = 0;
                    root.getChildren().remove(optionsMenuTitleText);
                    root.getChildren().remove(optionsBackButton);
                    root.getChildren().remove(optionsApplyButton);
                    root.getChildren().remove(optionsBackButtonText);
                    root.getChildren().remove(optionsApplyButtonText);
                    root.getChildren().remove(fullscreenText);
                    root.getChildren().remove(fOn);
                    root.getChildren().remove(fOff);

                    root.getChildren().add(titleText);
                    root.getChildren().add(startButton);
                    root.getChildren().add(startButtonText);
                    root.getChildren().add(optionsButton);
                    root.getChildren().add(optionsButtonText);
                    root.getChildren().add(quitButton);
                    root.getChildren().add(quitButtonText);
                    scene.removeEventFilter(MouseEvent.MOUSE_CLICKED, this);
                    scene.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventQuit);
                }
            }
        };
        EventHandler<MouseEvent> mouseEventOptions = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if(e.getSceneX()>=355 && e.getSceneX()<=685 && e.getSceneY()>=300 && e.getSceneY()<=375 && op[0]==0)
                {
                    op[0]=1;
                    root.getChildren().remove(titleText);
                    root.getChildren().remove(quitButton);
                    root.getChildren().remove(optionsButton);
                    root.getChildren().remove(startButton);
                    root.getChildren().remove(startButtonText);
                    root.getChildren().remove(optionsButtonText);
                    root.getChildren().remove(quitButtonText);

                    root.getChildren().add(optionsMenuTitleText);
                    root.getChildren().add(optionsBackButton);
                    root.getChildren().add(optionsApplyButton);
                    root.getChildren().add(optionsApplyButtonText);
                    root.getChildren().add(optionsBackButtonText);
                    root.getChildren().add(fullscreenText);
                    root.getChildren().add(fOff);
                    root.getChildren().add(fOn);

                    scene.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventQuit);
                    scene.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventBackButtonOptions);


                }
            }
        };


        EventHandler<MouseEvent> mouseEventStartButton = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if(e.getSceneX()>=355 && e.getSceneX() <= 685 && e.getSceneY()>=200 && e.getSceneY()<=275)
                {
                    root.getChildren().remove(titleText);
                    root.getChildren().remove(quitButton);
                    root.getChildren().remove(optionsButton);
                    root.getChildren().remove(startButton);
                    root.getChildren().remove(startButtonText);
                    root.getChildren().remove(optionsButtonText);
                    root.getChildren().remove(quitButtonText);

                    scene.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventQuit);
                    scene.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventOptions);
                    scene.removeEventFilter(MouseEvent.MOUSE_CLICKED, this);
                    scene.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventBackButtonOptions);

                    root.getChildren().add(craneLowArm);
                    root.getChildren().add(craneHighArm);
                    root.getChildren().add(b1L);
                    root.getChildren().add(b1D);
                    root.getChildren().add(b1R);
                    root.getChildren().add(b2D);
                    root.getChildren().add(b2L);
                    root.getChildren().add(b2R);
                    root.getChildren().add(Crane);
                    root.getChildren().add(cL1);
                    root.getChildren().add(cL2);
                    root.getChildren().add(cR1);
                    root.getChildren().add(cR2);
                    root.getChildren().add(cLine);
                    root.getChildren().add(cMLine);
                    root.getChildren().add(p1);
                    root.getChildren().add(p2);


                    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent e) {
                            if(e.getCode()== KeyCode.LEFT && craneXPos[0]>=250 && canSlide[0] == true)
                            {
                                cmx1V[0]-=10;
                                cMLine.setStartX(cmx1V[0]);
                                cMLine.setEndX(cmx1V[0]);
                                cR2x1V[0]-=10;
                                cR2x2V[0]-=10;
                                cR2.setStartX(cR2x1V[0]);
                                cR2.setEndX(cR2x2V[0]);
                                cR1x1V[0]-=10;
                                cR1x2V[0]-=10;
                                cR1.setStartX(cR1x1V[0]);
                                cR1.setEndX(cR1x2V[0]);
                                cL2x1V[0]-=10;
                                cL2x2V[0]-=10;
                                cL2.setStartX(cL2x1V[0]);
                                cL2.setEndX(cL2x2V[0]);
                                cL1x1V[0]-=10;
                                cL1x2V[0]-=10;
                                cL1.setStartX(cL1x1V[0]);
                                cL1.setEndX(cL1x2V[0]);
                                craneXPos[0]-=10;
                                Crane.setX(craneXPos[0]);
                                cLine.setStartX(cL1x1V[0]);
                                cLine.setEndX(cR1x1V[0]);
                                if(isCarried[0]==true)
                                {
                                    if(p1c[0]==true)
                                    {
                                        p1.setX(p1Xpos[0]-=10);
                                    }
                                    if(p2c[0]==true)
                                    {
                                        p2.setX(p2Xpos[0]-=10);
                                    }
                                }
                            }
                            else if(e.getCode()==KeyCode.RIGHT && craneXPos[0]<=850 && canSlide[0] == true)
                            {
                                cmx1V[0]+=10;
                                cMLine.setStartX(cmx1V[0]);
                                cMLine.setEndX(cmx1V[0]);
                                cR2x1V[0]+=10;
                                cR2x2V[0]+=10;
                                cR2.setStartX(cR2x1V[0]);
                                cR2.setEndX(cR2x2V[0]);

                                cR1x1V[0]+=10;
                                cR1x2V[0]+=10;
                                cR1.setStartX(cR1x1V[0]);
                                cR1.setEndX(cR1x2V[0]);
                                cL2x1V[0]+=10;
                                cL2x2V[0]+=10;
                                cL2.setStartX(cL2x1V[0]);
                                cL2.setEndX(cL2x2V[0]);
                                cL1x1V[0]+=10;
                                cL1x2V[0]+=10;

                                cL1.setStartX(cL1x1V[0]);
                                cL1.setEndX(cL1x2V[0]);
                                craneXPos[0]+=10;
                                Crane.setX(craneXPos[0]);
                                cLine.setStartX(cL1x1V[0]);
                                cLine.setEndX(cR1x1V[0]);
                                if(isCarried[0]==true)
                                {
                                    if(p1c[0]==true)
                                    {
                                        p1.setX(p1Xpos[0]+=10);
                                    }
                                    if(p2c[0]==true)
                                    {
                                        p2.setX(p2Xpos[0]+=10);
                                    }
                                }
                            }

                            else if(e.getCode()==KeyCode.SPACE)
                            {
                                System.out.println("Box = " + p1.getY());
                                System.out.println("Crane = " + cMLine.getEndY());
                                System.out.println(isCarried[0]);
                                if(failedCatch[0]==true && isCarried[0]==false)
                                {
                                    cmyV[0]-=10;
                                    cMLine.setEndY(cmyV[0]);

                                    cL1y1V[0]-=10;
                                    cL1y2V[0]-=10;
                                    cL1.setStartY(cL1y1V[0]);
                                    cL1.setEndY(cL1y2V[0]);
                                    cL2y1V[0]-=10;
                                    cL2y2V[0]-=10;
                                    cL2.setStartY(cL2y1V[0]);
                                    cL2.setEndY(cL2y2V[0]);
                                    cR2y1V[0]-=10;
                                    cR2y2V[0]-=10;
                                    cR2.setStartY(cR2y1V[0]);
                                    cR2.setEndY(cR2y2V[0]);
                                    cR1y1V[0]-=10;
                                    cR1y2V[0]-=10;
                                    cR1.setStartY(cR1y1V[0]);
                                    cR1.setEndY(cR1y2V[0]);
                                    cLine.setStartY(cL1y1V[0]);
                                    cLine.setEndY(cL1y1V[0]);
                                }
                               if(cLine.getEndX()>=p1.getX()+30&&cLine.getEndX()<=p1.getX()+50)
                               {
                                   if(isCarried[0]==false && cLine.getEndY()<=285)
                                   {
                                       failedCatch[0]=false;
                                   }
                                   if(cLine.getEndY()+20>=p1.getY() && p1b1[0]==false)
                                   {
                                       canSlide[0] =false;
                                       p1Xpos[0] =p1.getX();
                                       p1Ypos[0] = p1.getY();
                                       isCarried[0]=true;
                                       p1c[0]=true;
                                   }
                                   if(cLine.getEndY() <= 500 && isCarried[0]==false && failedCatch[0]==false) {
                                       cmyV[0] += 10;
                                       cMLine.setEndY(cmyV[0]);
                                       cL1y1V[0] += 10;
                                       cL1y2V[0] += 10;
                                       cL1.setStartY(cL1y1V[0]);
                                       cL1.setEndY(cL1y2V[0]);
                                       cL2y1V[0] += 10;
                                       cL2y2V[0] += 10;
                                       cL2.setStartY(cL2y1V[0]);
                                       cL2.setEndY(cL2y2V[0]);
                                       cR2y1V[0] += 10;
                                       cR2y2V[0] += 10;
                                       cR2.setStartY(cR2y1V[0]);
                                       cR2.setEndY(cR2y2V[0]);
                                       cR1y1V[0] += 10;
                                       cR1y2V[0] += 10;
                                       cR1.setStartY(cR1y1V[0]);
                                       cR1.setEndY(cR1y2V[0]);
                                       cLine.setStartY(cL1y1V[0]);
                                       cLine.setEndY(cL1y1V[0]);
                                   }
                                   else if(isCarried[0]==true && cMLine.getEndY()>=285)
                                   {
                                       if(cMLine.getEndY()==355 && power[0] < p1Weight)
                                       {
                                           failedCatch[0]=true;
                                           isCarried[0]=false;
                                           p1b1[0]=false;
                                           p1.setY(525);
                                           canSlide[0]=true;
                                           power[0] = rand.nextInt(25);
                                       }
                                       else
                                       {
                                           p1.setY(p1Ypos[0]-=10);
                                           cmyV[0]-=10;
                                           cMLine.setEndY(cmyV[0]);

                                           cL1y1V[0]-=10;
                                           cL1y2V[0]-=10;
                                           cL1.setStartY(cL1y1V[0]);
                                           cL1.setEndY(cL1y2V[0]);
                                           cL2y1V[0]-=10;
                                           cL2y2V[0]-=10;
                                           cL2.setStartY(cL2y1V[0]);
                                           cL2.setEndY(cL2y2V[0]);
                                           cR2y1V[0]-=10;
                                           cR2y2V[0]-=10;
                                           cR2.setStartY(cR2y1V[0]);
                                           cR2.setEndY(cR2y2V[0]);
                                           cR1y1V[0]-=10;
                                           cR1y2V[0]-=10;
                                           cR1.setStartY(cR1y1V[0]);
                                           cR1.setEndY(cR1y2V[0]);
                                           cLine.setStartY(cL1y1V[0]);
                                           cLine.setEndY(cL1y1V[0]);
                                       }

                                   }
                                    if(isCarried[0]==true && cMLine.getEndY()<=275)
                                    {
                                        canSlide[0]=true;
                                    }
                               }
                               if(isCarried[0]==true && cMLine.getStartX()>=680)
                               {
                                   isCarried[0]=false;
                                   p1b1[0]=true;
                                   p1.setY(525);
                                   p1c[0]=false;
                               }
                               else if(cLine.getEndX()>=p2.getX()+30&&cLine.getEndX()<=p2.getX()+50)
                                {
                                    if(isCarried[0]==false && cLine.getEndY()<=285)
                                    {
                                        failedCatch[0]=false;
                                    }
                                    if(cLine.getEndY()+20>=p2.getY() && p2b1[0]==false && cLine.getEndX()>=p2.getX()+30&&cLine.getEndX()<=p2.getX()+50)
                                    {
                                        canSlide[0] =false;
                                        p2Xpos[0] =p2.getX();
                                        p2Ypos[0] = p2.getY();
                                        isCarried[0]=true;
                                        p2c[0]=true;
                                    }
                                    if(cLine.getEndY() <= 500 && isCarried[0]==false && failedCatch[0]==false) {
                                        cmyV[0] += 10;
                                        cMLine.setEndY(cmyV[0]);
                                        cL1y1V[0] += 10;
                                        cL1y2V[0] += 10;
                                        cL1.setStartY(cL1y1V[0]);
                                        cL1.setEndY(cL1y2V[0]);
                                        cL2y1V[0] += 10;
                                        cL2y2V[0] += 10;
                                        cL2.setStartY(cL2y1V[0]);
                                        cL2.setEndY(cL2y2V[0]);
                                        cR2y1V[0] += 10;
                                        cR2y2V[0] += 10;
                                        cR2.setStartY(cR2y1V[0]);
                                        cR2.setEndY(cR2y2V[0]);
                                        cR1y1V[0] += 10;
                                        cR1y2V[0] += 10;
                                        cR1.setStartY(cR1y1V[0]);
                                        cR1.setEndY(cR1y2V[0]);
                                        cLine.setStartY(cL1y1V[0]);
                                        cLine.setEndY(cL1y1V[0]);
                                    }
                                    else if(isCarried[0]==true && cMLine.getEndY()>=285)
                                    {
                                        if(cMLine.getEndY()==355 && power[0] < p2Weight)
                                        {
                                            failedCatch[0]=true;
                                            isCarried[0]=false;
                                            p2b1[0]=false;
                                            p2.setY(525);
                                            canSlide[0]=true;
                                            power[0] = rand.nextInt(25);
                                        }
                                        else
                                        {
                                            p2.setY(p2Ypos[0]-=10);
                                            cmyV[0]-=10;
                                            cMLine.setEndY(cmyV[0]);

                                            cL1y1V[0]-=10;
                                            cL1y2V[0]-=10;
                                            cL1.setStartY(cL1y1V[0]);
                                            cL1.setEndY(cL1y2V[0]);
                                            cL2y1V[0]-=10;
                                            cL2y2V[0]-=10;
                                            cL2.setStartY(cL2y1V[0]);
                                            cL2.setEndY(cL2y2V[0]);
                                            cR2y1V[0]-=10;
                                            cR2y2V[0]-=10;
                                            cR2.setStartY(cR2y1V[0]);
                                            cR2.setEndY(cR2y2V[0]);
                                            cR1y1V[0]-=10;
                                            cR1y2V[0]-=10;
                                            cR1.setStartY(cR1y1V[0]);
                                            cR1.setEndY(cR1y2V[0]);
                                            cLine.setStartY(cL1y1V[0]);
                                            cLine.setEndY(cL1y1V[0]);
                                        }

                                    }
                                    if(isCarried[0]==true && cMLine.getEndY()<=275)
                                    {
                                        canSlide[0]=true;
                                    }
                                }
                                if(isCarried[0]==true && cMLine.getStartX()>=680)
                                {
                                    isCarried[0]=false;
                                    p2b1[0]=true;
                                    p2.setY(525);
                                    p2c[0]=false;
                                }
                            }
                        }
                    });
                }
            }
        };

        registerHandler(quitButton);
        registerHandler(startButton);
        registerHandler(optionsButton);
        registerHandler(optionsBackButton);
        registerHandler(optionsApplyButton);

        fsText(fOff);
        fsText(fOn);

        root.getChildren().add(titleText);
        root.getChildren().add(startButton);
        root.getChildren().add(startButtonText);
        root.getChildren().add(optionsButton);
        root.getChildren().add(optionsButtonText);
        root.getChildren().add(quitButton);
        root.getChildren().add(quitButtonText);
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventQuit);
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventOptions);
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventStartButton);
        stage.setScene(scene);
        stage.show();
    }

    private void registerHandler(Shape s)
    {
        s.setOnMouseEntered(e -> s.setStroke(Color.YELLOW));
        s.setOnMouseExited(e -> s.setStroke(Color.WHITE));
    }


    private void fsText(Text t)
    {
        t.setOnMouseEntered(e -> t.setFill(Color.YELLOW));
        t.setOnMouseExited(e -> t.setFill(Color.WHITE));
    }

    public static void main(String[] args) {
        launch();
    }
}