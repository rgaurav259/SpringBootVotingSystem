# SpringBootVotingSystem
This is a Spring REST controller for a simple candidate voting portal. 
It has endpoints for entering a candidate, casting a vote for a candidate, counting the votes for a specific candidate,
listing all the votes for all candidates, and determining the winner of the voting.

The enterCandidate endpoint accepts a name request parameter and adds it to a map of candidates with a vote count of 0.

The castVote endpoint accepts a name request parameter and increments the vote count for that candidate if it exists in the map. 
If the candidate does not exist, it throws an IllegalArgumentException.

The countVote endpoint accepts a name request parameter and returns the vote count for that candidate if it exists in the map. 
If the candidate does not exist, it throws an IllegalArgumentException.

The listVotes endpoint returns the entire map of candidates and their vote counts.

The getWinner endpoint determines the candidate with the most votes and returns their name.

This is just a simple example and does not include features such as authentication or a database for storing the votes. 
It should not be used for any actual voting applications.
