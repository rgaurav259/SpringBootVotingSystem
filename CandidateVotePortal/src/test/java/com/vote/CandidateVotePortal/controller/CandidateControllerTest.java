package com.vote.CandidateVotePortal.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CandidateControllerTest {

        @Autowired
        private CandidateController candidateController;

         @Test
         public  void testEnterCandidate() {
            candidateController.enterCandidate("gaurav");
            assertTrue(candidateController.candidates.containsKey("gaurav"));
            assertEquals(0, candidateController.candidates.get("gaurav").intValue());
          }

        @Test
        public void testCastVote() {
            candidateController.enterCandidate("gaurav");
            int voteCount = candidateController.castVote("gaurav");
            assertEquals(1, voteCount);
            assertEquals(1, candidateController.candidates.get("gaurav").intValue());
        }

        @Test
        public void testCastVote_invalidCandidate() {
            assertThrows(IllegalArgumentException.class, () -> candidateController.castVote("Invalid candidate"));
        }

        @Test
        public void testCountVote() {
            candidateController.enterCandidate("gaurav");
            candidateController.castVote("gaurav");
            int voteCount = candidateController.countVote("gaurav");
            assertEquals(1, voteCount);
        }

        @Test
        public void testCountVote_invalidCandidate() {
            assertThrows(IllegalArgumentException.class, () -> candidateController.countVote("Invalid candidate"));
        }

        @Test
        public void testListVotes() {
            candidateController.enterCandidate("gaurav");
            candidateController.enterCandidate("raju");
            Map<String, Integer> votes = candidateController.listVotes();
            assertTrue(votes.containsKey("gaurav"));
            assertTrue(votes.containsKey("raju"));
        }

        @Test
        public void testGetWinner() {
            candidateController.enterCandidate("gaurav");
            candidateController.enterCandidate("raju");
            candidateController.castVote("gaurav");
            candidateController.castVote("gaurav");
            String winner = candidateController.getWinner();
            assertEquals("gaurav", winner);
        }
}