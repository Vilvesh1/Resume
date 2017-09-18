/*
 * This is a menu driven program that implements the following Binary Search Tree Operations
 * FIND (item)
 * INSERT (item)
 * DELETE (item)
 * DELETE_TREE (delete all nodes - be careful with the traversal!)
 * EXIT PROGRAM
 * 
 * Vilvesh Srinivasan
 * COSC 2436
 */

import static java.lang.System.out;
import java.util.Scanner;

public class A11{
  
public static void main(String[] args){
  
Scanner scan = new Scanner(System.in);

BinaryST bst = new BinaryST();
int i;

i = 1;
while (i == 1) {
out.println("");
out.println("  ***BINARY SEARCH TREE OPERATIONS***\n");
out.println("                 MENU ");
out.println("---------------------------------------");
out.println("1. FIND (item)");
out.println("2. INSERT (item)");
out.println("3. DELETE (item)");
out.println("4. DELETE_TREE (delete all nodes - be careful with the traversal!)");
out.println("5. EXIT PROGRAM ");
out.println("--------------------------------------");
out.printf("Enter your choice from the menu:\t");
out.println("");

int choice = scan.nextInt();

switch (choice){
  
case 1 :
out.println("");
out.println("Enter an integer element to find in tree");
out.println("Search result : "+ bst.findintree( scan.nextInt() ));
break;

case 2 :
out.println("");
out.println("Enter an integer element to insert into the tree");
bst.inserttotree( scan.nextInt() );   
break;

case 3 :
out.println("");
out.println("Enter an integer element to delete from the tree");
bst.deleteavalue( scan.nextInt() );   
break; 

case 4 :
bst.deletefulltree();
break;

case 5:
out.println("");
out.println("Bye!");
i++;
break;

default :
out.println("");
out.println("Wrong Entry. Please try again. \n");
break;   
}

if ( i == 1){
out.println("");
out.print("Post-order : ");
bst.posto();
out.println("");
out.print("Pre-order : ");
bst.preo();
out.println("");
out.print("In-order : ");
bst.ino();

}

}   
}
}

class Bstn{
Bstn l, r;
int d;

public Bstn(){
d= 0;
r = null;
l = null;
}

public Bstn(int x){
d = x;
r = null;
l = null;
}

public void sr(Bstn x){
r = x;
}

public void sl(Bstn x){
l = x;
}

public Bstn gr(){
return r;
}

public Bstn gl(){
return l;
}

public int gd(){
return d;
}
}

class BinaryST{
private Bstn base;


private Bstn inserttotree(Bstn n, int information){
  if (n == null){
  n = new Bstn(information);
}
else{
  if (information <= n.gd()){
n.l
 = inserttotree(n.l
, information);
}
  else{
n.r = inserttotree(n.r, information);
}
}
return n;
}

public boolean na(){
return base == null;
}

public BinaryST(){
base = null;
}

public void inserttotree(int information){
base = inserttotree(base, information);
}

public void deletefulltree() {
while(!na())
base = deleteavalue(base, base.gd());
}

public void deleteavalue(int u){
  if (na()){
out.println("The tree is empty");
  }
  else if (findintree(u) == false){
out.println("Sorry "+ u +" is not present in the tree");
  }
else{
base = deleteavalue(base, u);
out.println(u+ " has been deleted from the tree");
}
}
private Bstn deleteavalue(Bstn base, int u){
Bstn p, p2, n;
if (base.gd() == u){
Bstn lt, rt;
lt = base.gl();
rt = base.gr();
if (lt == null && rt == null){
return null;
}
else if (lt == null){
p = rt;
return p;
}
else if (rt == null){
p = lt;
return p;
}
else{
p2 = rt;
p = rt;
while (p.gl() != null)
p = p.gl();
p.sl(lt);
return p2;
}
}
if (u < base.gd()){
n = deleteavalue(base.gl(), u);
base.sl(n);
}
else{
n = deleteavalue(base.gr(), u);
base.sr(n);   
}
return base;
}

public boolean findintree(int avalue){
return findintree(base, avalue);
}

private boolean findintree(Bstn r, int avalue){
boolean discovered = false;
while ((r != null) && !discovered){
int ravalue = r.gd();
if (avalue < ravalue){
r = r.gl();
}
else if (avalue > ravalue){
r = r.gr();
}
else{
discovered = true;
break;
}
discovered = findintree(r, avalue);
}
return discovered;
}

private void posto(Bstn r){
if (r != null){
posto(r.gl());   
posto(r.gr());
out.print(r.gd() +" ");
}
}

public void posto(){
posto(base);
}

private void ino(Bstn r){
if (r != null){
ino(r.gl());
out.print(r.gd() +" ");
ino(r.gr());
}
}

public void ino(){
ino(base);
}

private void preo(Bstn r){
if (r != null){
out.print(r.gd() +" ");
preo(r.gl());   
preo(r.gr());
}
}

public void preo(){
preo(base);
}


}

