package vdm;

//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at 2012-12-06 by the VDM++ to JAVA Code Generator
// (v8.1.1b - Thu 30-Oct-2008 14:59:38)
//
// Supported compilers: jdk 1.4/1.5/1.6
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// ***** VDMTOOLS START Name=package KEEP=NO
// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=NO

import jp.co.csk.vdm.toolbox.VDM.*;
import java.util.*;



public class Game implements EvaluatePP {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=board KEEP=NO
  private volatile Board board = null;
// ***** VDMTOOLS END Name=board

// ***** VDMTOOLS START Name=players KEEP=NO
  @SuppressWarnings("rawtypes")
private volatile HashSet players = new HashSet();
// ***** VDMTOOLS END Name=players

// ***** VDMTOOLS START Name=currentPieceType KEEP=NO
  private volatile Object currentPieceType = null;
// ***** VDMTOOLS END Name=currentPieceType

// ***** VDMTOOLS START Name=sentinel KEEP=NO
  volatile Sentinel sentinel;
// ***** VDMTOOLS END Name=sentinel


// ***** VDMTOOLS START Name=GameSentinel KEEP=NO
  class GameSentinel extends Sentinel {

    public final int put = 0;

    public final int Game = 1;

    public final int move = 2;

    public final int reset = 3;

    public final int remove = 4;

    public final int movable = 5;

    public final int getBoard = 6;

    public final int puttable = 7;

    public final int removable = 8;

    public final int isPhaseOne = 9;

    public final int isPhaseTwo = 10;

    public final int changePlayer = 11;

    public final int getCurrentPlayer = 12;

    public final int getCurrentPieceType = 13;

    public final int getUnplayedPieceCount = 14;

    public final int nr_functions = 15;


    public GameSentinel () throws CGException {}


    public GameSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=GameSentinel
;

// ***** VDMTOOLS START Name=evaluatePP#1|int KEEP=NO
  public Boolean evaluatePP (int fnr) throws CGException {
    return new Boolean(true);
  }
// ***** VDMTOOLS END Name=evaluatePP#1|int


// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new GameSentinel(this);
    }
    catch (CGException e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=vdm_init_Game KEEP=NO
  private void vdm_init_Game () throws CGException {
    try {
      setSentinel();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=vdm_init_Game


// ***** VDMTOOLS START Name=Game KEEP=NO
  @SuppressWarnings({ "rawtypes", "unchecked" })
public Game () throws CGException {
    try {

      vdm_init_Game();
      {

        board = (Board) UTIL.clone(new Board());
        currentPieceType = UTIL.clone(new quotes.WHITE());
        HashSet rhs_3 = new HashSet();
        rhs_3 = new HashSet();
        rhs_3.add(new Player(new quotes.WHITE()));
        rhs_3.add(new Player(new quotes.BLACK()));
        players = (HashSet) UTIL.clone(rhs_3);
      }
      setSentinel();
    }
    catch (Throwable e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=Game


// ***** VDMTOOLS START Name=reset KEEP=NO
  @SuppressWarnings({ "rawtypes", "unchecked" })
public void reset () throws CGException {

    sentinel.entering(((GameSentinel) sentinel).reset);
    try {

      board = (Board) UTIL.clone(new Board());
      currentPieceType = UTIL.clone(new quotes.WHITE());
      HashSet rhs_3 = new HashSet();
      rhs_3 = new HashSet();
      rhs_3.add(new Player(new quotes.WHITE()));
      rhs_3.add(new Player(new quotes.BLACK()));
      players = (HashSet) UTIL.clone(rhs_3);
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).reset);
    }
  }
// ***** VDMTOOLS END Name=reset


// ***** VDMTOOLS START Name=put#1|Vector KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean put (final Vector coord) throws CGException {

    if (!this.pre_put(coord).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in put");
    sentinel.entering(((GameSentinel) sentinel).put);
    try {

      HashSet mills = new HashSet();
      Player player = getCurrentPlayer();
      HashSet pMills = new HashSet();
      pMills = player.getMills();
      board.put(currentPieceType, coord);
      HashSet rhs_5 = new HashSet();
      rhs_5 = board.getMills(currentPieceType);
      mills = (HashSet) UTIL.clone(rhs_5);
      player.setMills(mills);
      return new Boolean((new Integer(pMills.size()).intValue()) < (new Integer(mills.size()).intValue()));
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).put);
    }
  }
// ***** VDMTOOLS END Name=put#1|Vector


// ***** VDMTOOLS START Name=pre_put#1|Vector KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean pre_put (final Vector coord) throws CGException {

    Boolean varRes_2 = null;
    varRes_2 = board.validCoords(coord);
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_put#1|Vector


// ***** VDMTOOLS START Name=getBoard KEEP=NO
  public Board getBoard () throws CGException {

    sentinel.entering(((GameSentinel) sentinel).getBoard);
    try {
      return (Board) board;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).getBoard);
    }
  }
// ***** VDMTOOLS END Name=getBoard


// ***** VDMTOOLS START Name=remove#1|Vector KEEP=NO
  @SuppressWarnings("rawtypes")
public void remove (final Vector coord) throws CGException {

    if (!this.pre_remove(coord).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in remove");
    sentinel.entering(((GameSentinel) sentinel).remove);
    try {

      board.remove(coord);
      changePlayer();
      Player obj_6 = null;
      obj_6 = (Player) getCurrentPlayer();
      HashSet par_7 = new HashSet();
      par_7 = board.getMills(currentPieceType);
      obj_6.setMills(par_7);
      changePlayer();
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).remove);
    }
  }
// ***** VDMTOOLS END Name=remove#1|Vector


// ***** VDMTOOLS START Name=pre_remove#1|Vector KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean pre_remove (final Vector coord) throws CGException {

    Boolean varRes_2 = null;
    varRes_2 = board.validCoords(coord);
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_remove#1|Vector


// ***** VDMTOOLS START Name=isPhaseOne KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean isPhaseOne () throws CGException {

    if (!this.pre_isPhaseOne().booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in isPhaseOne");
    sentinel.entering(((GameSentinel) sentinel).isPhaseOne);
    try {

      {

        Player p = null;
        for (Iterator enm_9 = players.iterator(); enm_9.hasNext(); ) {

          Player elem_2 = (Player) enm_9.next();
          p = (Player) elem_2;
          {

            Boolean cond_5 = null;
            Integer var1_6 = null;
            var1_6 = p.getUnplayedPieces();
            cond_5 = new Boolean((var1_6.intValue()) > (new Integer(0).intValue()));
            if (cond_5.booleanValue()) 
              return new Boolean(true);
          }
        }
      }
      return new Boolean(false);
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).isPhaseOne);
    }
  }
// ***** VDMTOOLS END Name=isPhaseOne


// ***** VDMTOOLS START Name=pre_isPhaseOne KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean pre_isPhaseOne () throws CGException {
    return new Boolean(!UTIL.equals(players, new HashSet()));
  }
// ***** VDMTOOLS END Name=pre_isPhaseOne


// ***** VDMTOOLS START Name=isPhaseTwo KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean isPhaseTwo () throws CGException {

    if (!this.pre_isPhaseTwo().booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in isPhaseTwo");
    sentinel.entering(((GameSentinel) sentinel).isPhaseTwo);
    try {

      {

        Player p = null;
        for (Iterator enm_9 = players.iterator(); enm_9.hasNext(); ) {

          Player elem_2 = (Player) enm_9.next();
          p = (Player) elem_2;
          {

            Boolean cond_5 = null;
            Integer var1_6 = null;
            var1_6 = p.getUnplayedPieces();
            cond_5 = new Boolean((var1_6.intValue()) > (new Integer(0).intValue()));
            if (cond_5.booleanValue()) 
              return new Boolean(false);
          }
        }
      }
      return new Boolean(true);
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).isPhaseTwo);
    }
  }
// ***** VDMTOOLS END Name=isPhaseTwo


// ***** VDMTOOLS START Name=pre_isPhaseTwo KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean pre_isPhaseTwo () throws CGException {
    return new Boolean(!UTIL.equals(players, new HashSet()));
  }
// ***** VDMTOOLS END Name=pre_isPhaseTwo


// ***** VDMTOOLS START Name=getCurrentPlayer KEEP=NO
  @SuppressWarnings("rawtypes")
public Player getCurrentPlayer () throws CGException {

    if (!this.pre_getCurrentPlayer().booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in getCurrentPlayer");
    sentinel.entering(((GameSentinel) sentinel).getCurrentPlayer);
    try {

      Player player = null;
      {

        Player p = null;
        for (Iterator enm_9 = players.iterator(); enm_9.hasNext(); ) {

          Player elem_2 = (Player) enm_9.next();
          p = (Player) elem_2;
          {

            Boolean cond_5 = null;
            Object var1_6 = null;
            var1_6 = p.getPieceType();
            cond_5 = new Boolean(UTIL.equals(var1_6, currentPieceType));
            if (cond_5.booleanValue()) 
              player = (Player) UTIL.clone(p);
          }
        }
      }
      return (Player) player;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).getCurrentPlayer);
    }
  }
// ***** VDMTOOLS END Name=getCurrentPlayer


// ***** VDMTOOLS START Name=pre_getCurrentPlayer KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean pre_getCurrentPlayer () throws CGException {
    return new Boolean(!UTIL.equals(players, new HashSet()));
  }
// ***** VDMTOOLS END Name=pre_getCurrentPlayer


// ***** VDMTOOLS START Name=move#2|Vector|Vector KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean move (final Vector origin, final Vector dest) throws CGException {

    if (!this.pre_move(origin, dest).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in move");
    sentinel.entering(((GameSentinel) sentinel).move);
    try {

      board.remove(origin);
      return put(dest);
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).move);
    }
  }
// ***** VDMTOOLS END Name=move#2|Vector|Vector


// ***** VDMTOOLS START Name=pre_move#2|Vector|Vector KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean pre_move (final Vector origin, final Vector dest) throws CGException {

    Boolean varRes_3 = null;
    Boolean var1_4 = null;
    var1_4 = board.validCoords(origin);
    {
      if ((varRes_3 = var1_4).booleanValue()) {

        Boolean var2_6 = null;
        var2_6 = board.validCoords(dest);
        varRes_3 = var2_6;
      }
    }
    return varRes_3;
  }
// ***** VDMTOOLS END Name=pre_move#2|Vector|Vector


// ***** VDMTOOLS START Name=puttable#1|Vector KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean puttable (final Vector coord) throws CGException {

    if (!this.pre_puttable(coord).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in puttable");
    sentinel.entering(((GameSentinel) sentinel).puttable);
    try {

      Boolean tmpObj_3 = null;
      tmpObj_3 = board.puttable(coord);
      return tmpObj_3;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).puttable);
    }
  }
// ***** VDMTOOLS END Name=puttable#1|Vector


// ***** VDMTOOLS START Name=pre_puttable#1|Vector KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean pre_puttable (final Vector coord) throws CGException {

    Boolean varRes_2 = null;
    varRes_2 = board.validCoords(coord);
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_puttable#1|Vector


// ***** VDMTOOLS START Name=changePlayer KEEP=NO
  public void changePlayer () throws CGException {

    sentinel.entering(((GameSentinel) sentinel).changePlayer);
    try {
      if (new Boolean(UTIL.equals(currentPieceType, new quotes.WHITE())).booleanValue()) 
        currentPieceType = UTIL.clone(new quotes.BLACK());
      else 
        currentPieceType = UTIL.clone(new quotes.WHITE());
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).changePlayer);
    }
  }
// ***** VDMTOOLS END Name=changePlayer


// ***** VDMTOOLS START Name=removable#1|Vector KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean removable (final Vector coord) throws CGException {

    if (!this.pre_removable(coord).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in removable");
    sentinel.entering(((GameSentinel) sentinel).removable);
    try {

      Boolean rexpr_2 = null;
      rexpr_2 = board.removable(currentPieceType, coord);
      return rexpr_2;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).removable);
    }
  }
// ***** VDMTOOLS END Name=removable#1|Vector


// ***** VDMTOOLS START Name=pre_removable#1|Vector KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean pre_removable (final Vector coord) throws CGException {

    Boolean varRes_2 = null;
    varRes_2 = board.validCoords(coord);
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_removable#1|Vector


// ***** VDMTOOLS START Name=movable#2|Vector|Vector KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean movable (final Vector origin, final Vector dest) throws CGException {

    if (!this.pre_movable(origin, dest).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in movable");
    sentinel.entering(((GameSentinel) sentinel).movable);
    try {

      Boolean rexpr_3 = null;
      rexpr_3 = board.movable(currentPieceType, origin, dest);
      return rexpr_3;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).movable);
    }
  }
// ***** VDMTOOLS END Name=movable#2|Vector|Vector


// ***** VDMTOOLS START Name=pre_movable#2|Vector|Vector KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean pre_movable (final Vector origin, final Vector dest) throws CGException {

    Boolean varRes_3 = null;
    Boolean var1_4 = null;
    var1_4 = board.validCoords(origin);
    {
      if ((varRes_3 = var1_4).booleanValue()) {

        Boolean var2_6 = null;
        var2_6 = board.validCoords(dest);
        varRes_3 = var2_6;
      }
    }
    return varRes_3;
  }
// ***** VDMTOOLS END Name=pre_movable#2|Vector|Vector


// ***** VDMTOOLS START Name=getCurrentPieceType KEEP=NO
  public Object getCurrentPieceType () throws CGException {

    sentinel.entering(((GameSentinel) sentinel).getCurrentPieceType);
    try {
      return currentPieceType;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).getCurrentPieceType);
    }
  }
// ***** VDMTOOLS END Name=getCurrentPieceType


// ***** VDMTOOLS START Name=getUnplayedPieceCount KEEP=NO
  @SuppressWarnings({ "rawtypes", "unchecked" })
public HashMap getUnplayedPieceCount () throws CGException {

    if (!this.pre_getUnplayedPieceCount().booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in getUnplayedPieceCount");
    sentinel.entering(((GameSentinel) sentinel).getUnplayedPieceCount);
    try {

      HashMap count = new HashMap();
      {

        Player p = null;
        for (Iterator enm_8 = players.iterator(); enm_8.hasNext(); ) {

          Player elem_2 = (Player) enm_8.next();
          p = (Player) elem_2;
          {

            Object md_6 = null;
            md_6 = p.getPieceType();
            Integer mr_7 = null;
            mr_7 = p.getUnplayedPieces();
            count.put(md_6, mr_7);
          }
        }
      }
      return count;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).getUnplayedPieceCount);
    }
  }
// ***** VDMTOOLS END Name=getUnplayedPieceCount


// ***** VDMTOOLS START Name=pre_getUnplayedPieceCount KEEP=NO
  @SuppressWarnings("rawtypes")
public Boolean pre_getUnplayedPieceCount () throws CGException {
    return new Boolean(!UTIL.equals(players, new HashSet()));
  }
// ***** VDMTOOLS END Name=pre_getUnplayedPieceCount

}
;