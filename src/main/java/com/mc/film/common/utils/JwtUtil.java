package com.mc.film.common.utils;

import com.mc.film.common.exception.MyException;
import com.mc.film.common.model.JwtInfo;
import com.mc.film.common.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 *
 */
@Slf4j
public class JwtUtil {

	public static final String APP_SECRET = "c2t5MTgwMjMyMjA2";

	private static Key getKeyInstance() {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] bytes = DatatypeConverter.parseBase64Binary(APP_SECRET);
		return new SecretKeySpec(bytes, signatureAlgorithm.getJcaName());
	}

	/**
	 * token 加密
	 *
	 * @param jwtInfo
	 * @param expire
	 * @return
	 */
	public static String setJwtToken(JwtInfo jwtInfo, int expire) {

		return Jwts.builder()
				.setHeaderParam("alg", "HS256")    // 签名算法
				.setHeaderParam("type", "JWT")        // 令牌类型
				.setSubject("mc-user")      //主题
				.setIssuedAt(new Date())    //颁发时间
				.setExpiration(DateTime.now().plusSeconds(expire).toDate())    //过期时间 单位 (秒)
				.claim("id", jwtInfo.getId())
				.claim("username", jwtInfo.getUsername())
				.claim("nickname", jwtInfo.getNickname())
				.signWith(SignatureAlgorithm.HS256, getKeyInstance())
				.compact();
	}

	/**
	 * 判断token是否存在与有效
	 *
	 * @param request
	 * @return
	 */
	public static boolean checkJwtToken(HttpServletRequest request) {

		try {
			String jwtToken = request.getHeader("Admin-Token");

			if (StringUtils.isEmpty(jwtToken)) return false;

			Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwtToken);
		} catch (SignatureException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 判断token是否存在与有效
	 *
	 * @param jwtToken
	 * @return
	 */
	public static boolean checkJwtToken(String jwtToken) {

		if (StringUtils.isEmpty(jwtToken)) return false;

		try {
			Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwtToken);
		} catch (SignatureException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * token 解密
	 *
	 * @param request
	 * @return
	 */
	public static JwtInfo getUserInfoByToken(HttpServletRequest request) throws ExpiredJwtException {

		String jwtToken = request.getHeader("Admin-Token");

		JwtInfo jwtInfo = parseJwtToken(jwtToken);

		return jwtInfo;
	}

	/**
	 * token 解密
	 *
	 * @param jwtToken
	 * @return
	 */
	public static JwtInfo getUserInfoByToken(String jwtToken) throws ExpiredJwtException {

		JwtInfo jwtInfo = parseJwtToken(jwtToken);

		return jwtInfo;
	}

	/**
	 * token 解码
	 *
	 * @param jwtToken
	 * @return
	 */
	public static JwtInfo parseJwtToken(String jwtToken) {

		if (StringUtils.isEmpty(jwtToken)) {
			return null;
		}

		JwtInfo jwtInfo;

		try {
			Jws<Claims> claimsJws = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwtToken);
			Claims claims = claimsJws.getBody();

			jwtInfo = new JwtInfo(claims.get("id").toString(), claims.get("username").toString(), claims.get("nickname").toString());
		} catch (SignatureException e) {
			log.error("解析 token 失败 -> " + e.getMessage());
			throw new MyException(ResultCodeEnum.TOKEN_ILLEGAL);
		}

		return jwtInfo;
	}
}
