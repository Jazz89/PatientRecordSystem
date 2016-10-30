/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyKontrolerow;

import java.awt.event.ActionEvent;




/**
 *
 * @author JAzz
 */
abstract class Kontroler {
  
   abstract void doCreate(ActionEvent actionEvent);
   abstract void doRead(ActionEvent actionEvent);
   abstract void doUpdate(ActionEvent actionEvent);
   abstract void doDelete(ActionEvent actionEvent);
   abstract void doFind(ActionEvent actionEvent);
    
    
}
