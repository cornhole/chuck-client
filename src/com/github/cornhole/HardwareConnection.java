package com.github.cornhole;

import java.io.IOException;
import java.io.OutputStream;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

/**
 * Serial port connection class
 */
public class HardwareConnection {

	final private SerialPort serialPort;
	final private OutputStream outputStream;

	/**
	 * Create a new serial connection
	 * 
	 * @param port port identifier
	 * @param baudRate baud rate
	 * @throws Exception something went wrong :(
	 */
	public HardwareConnection(String port, int baudRate) throws Exception {
		serialPort = (SerialPort) CommPortIdentifier.getPortIdentifier(port).open(this.getClass().getName(), 2000);
		serialPort.setSerialPortParams(baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		outputStream = serialPort.getOutputStream();
	}

	/**
	 * Write a command to the serial
	 * port (includes a new line)
	 * 
	 * @param newCommand command
	 * @throws IOException something went wrong :(
	 */
	public void write(String newCommand) throws IOException {
		outputStream.write((newCommand+"\n").getBytes());
	}

	/**
	 * Disconnect from the serial port
	 * 
	 * @throws IOException something went wrong :(
	 */
	public void disconnect() throws IOException {
		serialPort.close();
	}

}
