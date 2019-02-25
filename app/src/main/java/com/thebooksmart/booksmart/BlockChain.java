package com.thebooksmart.booksmart;
import java.util.ArrayList;
import java.util.List;

public class BlockChain {


    private int difficulty;
    private List<block> blocks;

    public BlockChain(int difficulty) {
        this.difficulty = difficulty;
        blocks = new ArrayList<>();
        // create the first block
        block b = new block(0, System.currentTimeMillis(), null, "First Block");
        b.mineBlock(difficulty);
        blocks.add(b);
    }

    public int getDifficulty() {
        return difficulty;
    }

    public block latestBlock() {
        return blocks.get(blocks.size() - 1);
    }

    public block newBlock(String data) {
        block latestBlock = latestBlock();
        return new block(latestBlock.getIndex() + 1, System.currentTimeMillis(),
                latestBlock.getHash(), data);
    }

    public void addBlock(block b) {
        if (b != null) {
            b.mineBlock(difficulty);
            blocks.add(b);
        }
    }

    public boolean isFirstBlockValid() {
        block firstBlock = blocks.get(0);

        if (firstBlock.getIndex() != 0) {
            return false;
        }

        if (firstBlock.getPreviousHash() != null) {
            return false;
        }

        if (firstBlock.getHash() == null ||
                !block.calculateHash(firstBlock).equals(firstBlock.getHash())) {
            return false;
        }

        return true;
    }

    public boolean isValidNewBlock(block newBlock, block previousBlock) {
        if (newBlock != null  &&  previousBlock != null) {
            if (previousBlock.getIndex() + 1 != newBlock.getIndex()) {
                return false;
            }

            if (newBlock.getPreviousHash() == null  ||
                    !newBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }

            if (newBlock.getHash() == null  ||
                    !block.calculateHash(newBlock).equals(newBlock.getHash())) {
                return false;
            }

            return true;
        }

        return false;
    }

    public boolean isBlockChainValid() {
        if (!isFirstBlockValid()) {
            return false;
        }

        for (int i = 1; i < blocks.size(); i++) {
            block currentBlock = blocks.get(i);
            block previousBlock = blocks.get(i - 1);

            if (!isValidNewBlock(currentBlock, previousBlock)) {
                return false;
            }
        }

        return true;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (block block : blocks) {
            builder.append(block).append("\n");
        }

        return builder.toString();
    }

}




