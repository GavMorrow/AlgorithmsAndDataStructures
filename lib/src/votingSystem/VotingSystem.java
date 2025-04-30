package votingSystem;

public interface VotingSystem {
    void addVote(String candidate);

    int getVotes(String candidate);

    String winner();
}

