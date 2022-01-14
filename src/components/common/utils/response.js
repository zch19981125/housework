export const responseHandle = (response) => {
  if (!(response.data.code === '200')) {
    return false
  } else {
    return true
  }
}
