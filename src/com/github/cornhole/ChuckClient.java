package com.github.cornhole;


import java.util.Scanner;

/**
 * Example client to control the
 * CHUCK arm via serial commands
 */
public class ChuckClient {
	
	/**
	 * Executable start point
	 * 
	 * @param args command-line args, ignored
	 */
	public static void main(String[] args) {
		final int BAUD_RATE = 115200;
		final String PORT = "/dev/tty.usbserial-A9030QLX";
		
		/*  Set the LIST_PORTS constant to true
		 *  to list ports on the system and then use this
		 *  information to populate the PORT constant above
		 */
		final boolean LIST_PORTS = false;
		if (LIST_PORTS) {
			DiscoverPort.listPorts();
		} else {
			try (Scanner kb = new Scanner(System.in)) {
				
				// attempt connection, one-time reset
				final HardwareConnection arm = new HardwareConnection(PORT, BAUD_RATE);
				arm.write("resetArm");
				
				boolean done;
				do {
					final String cmd = kb.nextLine();
					done = cmd.equals("disconnect");
					if (!done) {
						arm.write(cmd);
					}
				} while (!done);
				
				arm.write("torqueOff");
				arm.disconnect();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
