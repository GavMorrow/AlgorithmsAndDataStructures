package votingSystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class VotingSystemTests {

    public abstract VotingSystem createVotingSystem();
    @Test
    @DisplayName("Test addVote and getVotes")
    void testAddAndGetVotes() {
        VotingSystem vs = createVotingSystem();
        vs.addVote("Alice");
        vs.addVote("Alice");
        vs.addVote("Bob");
        assertEquals(2, vs.getVotes("Alice"));
        assertEquals(1, vs.getVotes("Bob"));
    }

    @Test
    @DisplayName("Test addVote and winner")
    void testGetMaxVoteCandidate() {
        VotingSystem vs = createVotingSystem();
        vs.addVote("Alice");
        vs.addVote("Alice");
        vs.addVote("Bob");
        assertEquals("Alice", vs.winner());
    }
}
