package com.github.cornhole;


import java.util.Enumeration;

import gnu.io.CommPortIdentifier;

/**
 * Utility class for discovering communication
 * port identifiers
 */
public class DiscoverPort {
	
	/**
	 * Utility method to output
	 * communication ports
	 */
	public static void listPorts() {
		@SuppressWarnings("unchecked")
		Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier.getPortIdentifiers();
		
		System.out.printf("%n== Ports ==%n");
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier portIdentifier = portEnum.nextElement();
			System.out.printf("%s - %s%n", 
				portIdentifier.getName(),
				getPortTypeName(portIdentifier.getPortType()));
		}
	}

	private static String getPortTypeName(int portType) {
		switch (portType) {
		case CommPortIdentifier.PORT_I2C:
			return "I2C";
		case CommPortIdentifier.PORT_PARALLEL:
			return "Parallel";
		case CommPortIdentifier.PORT_RAW:
			return "Raw";
		case CommPortIdentifier.PORT_RS485:
			return "RS485";
		case CommPortIdentifier.PORT_SERIAL:
			return "Serial";
		default:
			return "unknown type";
		}
	}
}