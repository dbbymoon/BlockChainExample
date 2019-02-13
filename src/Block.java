import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
	private int blockSize;	// ��� ũ��
	private BlockHeader blockHeader;	// ��� ���
	private int transactionCount;	// �ŷ� ī��Ʈ
	private Object[] transactions;	// �ŷ�
	
	public Block(BlockHeader blockHeader, Object[] transactions) {
		this.blockHeader = blockHeader;
		this.transactions = transactions;
	}
	
	// getBlockHash() : ���� SHA-256 �˰����� �̿��� ��� �ؽ��� ��� 
	public String getBlockHash() throws NoSuchAlgorithmException{
		/* MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		
		// �ؽ� �� �� ����
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
