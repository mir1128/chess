package com.looobo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameProcessTest {
    GameProcess gameProcess = new GameProcess();

    private List<String> board = new ArrayList<>();

    private void initBoard() {
        board.add("rch(0,0),rma(1,0),rxg(2,0),rsh(3,0),rjg(4,0),rsh(5,0),rxg(6,0),rma(7,0),rch(8,0)");
        board.add("rpo(1,2),rpo(7,2)");
        board.add("rbn(0,3),rbn(2,3),rbn(4,3),rbn(6,3),rbn(8,3)");
        board.add("bbn(0,6),bbn(2,6),bbn(4,6),bbn(6,6),bbn(8,6)");
        board.add("bpo(1,7),bpo(7,7)");
        board.add("bch(0,9),bma(1,9),bxg(2,9),bsh(3,9),bjg(4,9),bsh(5,9),bxg(6,9),bma(7,9),bch(8,9)");
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void ShouldMoveCorrectly() throws Exception {
        gameProcess.execute("mov black pao (1,2) (4,2)");
        gameProcess.execute("mov red   pao (7,7) (4,7)");

        StringBuilder sb = new StringBuilder();
        sb.append("rch(0,0),rma(1,0),rxg(2,0),rsh(3,0),rjg(4,0),rsh(5,0),rxg(6,0),rma(7,0),rch(8,0)");
        sb.append("rpo(4,2),rpo(7,2)");
        sb.append("rbn(0,3),rbn(2,3),rbn(4,3),rbn(6,3),rbn(8,3)");
        sb.append("bbn(0,6),bbn(2,6),bbn(4,6),bbn(6,6),bbn(8,6)");
        sb.append("bpo(1,7),bpo(4,7)");
        sb.append("bch(0,9),bma(1,9),bxg(2,9),bsh(3,9),bjg(4,9),bsh(5,9),bxg(6,9),bma(7,9),bch(8,9)");

        assertEquals(gameProcess.dump(), sb.toString());

    }
}
