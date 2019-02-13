import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
	private int blockSize;	// 블록 크기
	private BlockHeader blockHeader;	// 블록 헤더
	private int transactionCount;	// 거래 카운트
	private Object[] transactions;	// 거래
	
	public Block(BlockHeader blockHeader, Object[] transactions) {
		this.blockHeader = blockHeader;
		this.transactions = transactions;
	}
	
	// getBlockHash() : 더블 SHA-256 알고리즘을 이용한 블록 해시의 계산 
	public String getBlockHash() throws NoSuchAlgorithmException{
		/* MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		
		// 해시 두 번 수행
		byte[] blockHash = messageDigest.digest(blockHeader.toString().getBytes());
		blockHash = messageDigest.digest(blockHash);
		
		return new String(blockHash, 0, blockHash.length); */
		String hash = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(blockHeader.toByteArray());
			byte[] blockHash = messageDigest.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < blockHash.length; i++) {
				sb.append(Integer.toString((blockHash[i] & 0xff) + 0x100, 16).substring(1));
			}
			hash = sb.toString();
		} catch (NoSuchAlgorithmException nse) {
			nse.printStackTrace();
			hash = null;
		}
		return hash;
	}
}
