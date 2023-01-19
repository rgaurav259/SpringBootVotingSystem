package com.vote.CandidateVotePortal.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CandidateController {

         Map<String, Integer> candidates = new HashMap<>();

        @PostMapping("/entercandidate")
        public void enterCandidate(@RequestParam("name") String name) {
            candidates.put(name, 0);
        }


        @GetMapping("/castvote")
        public int castVote(@RequestParam("name") String name) {
            if (!candidates.containsKey(name)) {
                throw new IllegalArgumentException("Invalid candidate name");
            }
            int voteCount = candidates.get(name);
            voteCount++;
            candidates.put(name, voteCount);
            return voteCount;
        }


        @GetMapping("/countvote")
        public int countVote(@RequestParam("name") String name) {
            if (!candidates.containsKey(name)) {
                throw new IllegalArgumentException("Invalid candidate name");
            }
            return candidates.get(name);
        }

        @GetMapping("/listvote")
        public Map<String, Integer> listVotes() {
            return candidates;
        }


    @GetMapping("/getwinner")
    public String getWinner() {
        int maxVotes = 0;
        String winner = "";
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner;
    }




}
