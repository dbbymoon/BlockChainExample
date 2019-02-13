import java.nio.charset.StandardCharsets;
import java.util.Arrays;

// 블록 헤더 
public class BlockHeader {
	private int version;	// 버전 
	private byte[] previousBlockHash;	// 이전 블록의 해시
	private int merkleRootHash;	// 머클 루트의 해시
	private int timestamp;	// 타임 스탬프 (블록 생성 시각)
	private int difficultyTarget;	// 난이도 목표
	private int nonce;	// 난스 (채굴 과정 작업 증명에서 사용되는 카운터)
	
	// 생성자 
	public BlockHeader(byte[] previousBlockHash, Object[] transactions) {
		this.previousBlockHash = previousBlockHash;
		this.merkleRootHash = this.calcMerkleRootHash(transactions);
	}
	// 거래 내역을 통해 머클 루트 해시 값을 계산하는 메서드
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
