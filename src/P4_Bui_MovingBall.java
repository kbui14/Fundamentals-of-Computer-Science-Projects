/* CS 225 - Fundamentals of Computer Science
 * File Name: P4_Lastname1_Lastname2_Client.java
 * Java Programming
 * Project 4 - Due 03/23/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * Description: This file contains the source code for project 4.
 */

public class P4_Bui_MovingBall extends Ball implements BallMethods {

	
	double circ = 0;
	double rate = 0;
	double prevPeak[] = {0.0};
	double newPeak;
	int count = 0;
	boolean goingUp;
	P4_Bui_MovingBall(double rad, double bsl, String imageNameWithExt) {
		super(rad, bsl, imageNameWithExt);
		
	}

	@Override
	public void ThrowBall(double hVelocity, double startingHeight) {
/////////////////////////////////////////////////////////////////////////////
// Throw the ball. This method does not really move the ball, but just SETS
// it off on its throw. Thus, it merely sets the following internal params:
// 		- Ball's horizontal velocity (xVelocity) to the hVelocity passed
//		  in, which is in pixels-per-frame
// 		- Ball's vertical velocity (yVelocity) to 0 pixels-per-frame
//		- Ball's height of it's center (ballCenterY) to the startingHeight,
//		  which is in pixels
//		- Ball's x position (in pixels) of it's center (ballCenterX) to a
//		  point that places the ball just off the screen
		xVelocity = hVelocity;
		yVelocity = 0;
		ballCenterY = startingHeight;
		ballCenterX = -radius;
		ballStillBouncing = true;
	}

	@Override
	public void RollBall(double hVelocity) {
/////////////////////////////////////////////////////////////////////////////
// Roll the ball. This method does not really move the ball, but just SETS
// it off on its roll. Thus, it merely sets the following internal params:
// 		- Ball's horizontal velocity (xVelocity) to the hVelocity passed
//		  in, which is in pixels-per-frame
//		- Ball's height of it's center (ballCenterY) to point so that the
//		  ball appears to be sitting on the ground
//		- Ball's x position (in pixels) of it's center (ballCenterX) to a
//		  point that places the ball just off the screen
		
		xVelocity = hVelocity;
		ballCenterY = radius;
		ballCenterX = -radius;
		
		
	}

	@Override
	public void AdvanceRollingBallSingleFrame() {
/////////////////////////////////////////////////////////////////////////////
// Move the ball to the right one frame. This is essentially moving the ball
// a number of pixels which is equal to the ball's xVelocity (which was set
// earlier by the RollBall method).
//
// The ball must also rotate at the CORRECT rate (e.g., if the circumference of
// a ball is 300 pixels (can compute from the ball's radius), then the ball
// must make one full rotation after moving 300 pixels.
		circ = 2*radius*Math.PI; 
		ballCenterX += xVelocity;
		rate = circ/360;
		degreesRotated += rate*5;
			
	}

	@Override
	public void AdvanceThrownBallSingleFrame() {
/////////////////////////////////////////////////////////////////////////////
// Move the ball to the right one frame. This is essentially moving the ball
// a number of pixels which is equal to the ball's xVelocity (which was set
// earlier by the ThrowBall method.
//
// The ball must also FALL with an acceleration of 9.8pixels/(frame*frame). That is,
// each time the ball is advanced, it's vertical velocity is also updated using the
// following velocity equation derived from physics:
//     newVelocity = initialVelocity + 9.8  		(we'll assume time always = 1 frame)
//
// When the ball hits the ground, it immediately loses some percent of it's speed,
// according to the bounceSpeedLoss (see below) variable in the Ball class, and then
// changes it's direction to start moving up. The ball will then begin to decelerate
// using the following equation:
//     newVelocity = initialVelocity - 9.8			(we'll assume time always = 1 frame)
// 
// NOTE: bounceSpeedLoss will be a number between 0-1. It should be applied as follows:
//       vVelocity = 1 - (vVelocity*bounceSpeedLoss);
//       Thus, if your velocity was 10, and bounceSpeedLoss was .15, the new velocity will
//		 be 8.5.
//
// Once the ball's velocity reaches 0 on it's upward trajectory, it simply changes direction
// to start falling again.
// 
// After a few bounces, the ball eventually bounces lower and lower. Each time the ball bounces
// and hits the ground, this method should examine the yVelocity at which the ball will be bouncing upwards.
// If the velocity is less than 10, then the ball should set the internal variable ballStillBouncing to
// false.
		//double intialVelocity = 0;
		//intialVelocity = xVelocity;
		//double newVelocity;
		ballCenterX += xVelocity;
		degreesRotated += 9.8;
		
		
		ballCenterY += yVelocity;
		if(ballCenterY <= radius){//when the ball hits the ground
			ballCenterY = radius; 
			yVelocity = -yVelocity + (yVelocity*bounceSpeedLoss);
			goingUp = true;
				if(yVelocity < 10)
					ballStillBouncing = false;
			
		}
		
		if(!goingUp)
			yVelocity -= 9.8;
		
		if(yVelocity >= 0){ //when ball is at its peak
			yVelocity -= 9.8;
			goingUp = false;
		}
		
		
			
		
			
		
		
		

	}

	@Override
	public boolean IsThrownBallStillBouncing() {
		// TODO Auto-generated method stub
		return ballStillBouncing;
	}

}
