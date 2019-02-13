import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class BlockchainDriver {
	List<Block> blockChain = new ArrayList<Block>();
	
	public static void main(String[] args) throws NoSuchAlgorithmException{
		
		// Genesis block - 최초 블록 생성
		String[] transactions = {"A sent 1k Bitcoins to B."};
		Block genesisBlock = new Block(new BlockHeader(null, transactions), transactions);
		System.out.println("Genesis Block Hash : "+genesisBlock.getBlockHash());
		
		// Second block 
		String[] secondTransactions = {"B sent 500 Bitcoins to A."};
		Block secondBlock = new Block(new BlockHeader(genesisBlock.getBlockHash().getBytes(), secondTransactions),secondTransactions);
		System.out.println("Second Block Hash : "+secondBlock.getBlockHash());
		
		// Third block
		String[] thirdTransactions = {"A sent 100 Bitcoins to C."};
		Block thirdBlock = new Block(new BlockHeader(secondBlock.getBlockHash().getBytes(), thirdTransactions), thirdTransactions);
		System.out.println("Third Block Hash : "+thirdBlock.getBlockHash());
		
		// Genesis 블록 변경
		System.out.println("Genesis Block 거래 내역 변경");
		transactions[0] = "A sent 10k Bitcoins to B.";
		genesisBlock = new Block(new BlockHeader(null, transactions), transactions);
		System.out.println("Genesis Block Hash : "+genesisBlock.getBlockHash());
		secondBlock = new Block(new BlockHeader(genesisBlock.getBlockHash().getBytes(), secondTransactions),secondTransactions);
		System.out.println("Second Block Hash : "+secondBlock.getBlockHash());
		thirdBlock = new Block(new BlockHeader(secondBlock.getBlockHash().getBytes(), thirdTransactions), thirdTransactions);
		System.out.println("Third Block Hash : "+thirdBlock.getBlockHash());
		
	}
}
