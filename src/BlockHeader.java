import java.nio.charset.StandardCharsets;
import java.util.Arrays;

// ��� ��� 
public class BlockHeader {
	private int version;	// ���� 
	private byte[] previousBlockHash;	// ���� ����� �ؽ�
	private int merkleRootHash;	// ��Ŭ ��Ʈ�� �ؽ�
	private int timestamp;	// Ÿ�� ������ (��� ���� �ð�)
	private int difficultyTarget;	// ���̵� ��ǥ
	private int nonce;	// ���� (ä�� ���� �۾� ������ ���Ǵ� ī����)
	
	// ������ 
	public BlockHeader(byte[] previousBlockHash, Object[] transactions) {
		this.previousBlockHash = previousBlockHash;
		this.merkleRootHash = this.calcMerkleRootHash(transactions);
	}
	// �ŷ� ������ ���� ��Ŭ ��Ʈ �ؽ� ���� ����ϴ� �޼���
	public int calcMerkleRootHash(Object[] transactions) {
		return Arrays.deepHashCode(transactions);
	}
	// toByteArray
	public byte[] toByteArray() {
		String tmpStr = "";
		if(previousBlockHash != null) {
			tmpStr += new String(previousBlockHash, 0, previousBlockHash.length);
		}
		tmpStr += merkleRootHash;
		return tmpStr.getBytes(StandardCharsets.UTF_8);
	}
	
}
