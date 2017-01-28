# CHUCK: Java Client

## Compile
1. To compile you will need the RXTX for Java library (used for serial communication to the Arbotix microcontroller).
 * Navigate to [RXTX website] (http://rxtx.qbang.org/wiki/index.php/Installation)
 * Download/install for your platform
 * macOS may need the following additional steps:
  * `mkdir /var/lock`
  * `sudo chmod go+rwx var/lock`
2. Open project in Eclipse
 * You may need to update the location to the RXTX jar

## Run
1. Make sure `chuck-arduino` has been uploaded to the Arbotix board
2. As needed, install drivers for FTDI USB cable
3. Provide power to the Arbotix board, connect via USB to your computer
4. Run `ChuckClient`
 * During your first run, set the `LIST_PORTS` constant in `main()` to `true`; run, copy the port identifier to the `PORT` constant; set `LIST_PORTS` to false
5. Supported commands:
 * `graspBeanBag`
 * `releaseBeanBag`
 * `throwBeanBag releaseVelocity releaseDelay` (e.g. `throwBeanBag 225 200`)
 * `rotateArm position` (e.g. `rotateArm 500`)
6. When done, issue the `disconnect` command to relax the arm and close the serial connection
 

## Author

Tyler Frasca<br />
tmfrasca@gmail.com<br />
http://tmfrasca.info
